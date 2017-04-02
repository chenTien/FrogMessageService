package common;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**Hibernate 工具类
 * Created by chen.Tian on 2017/3/18.
 */
@Repository("hibernateDaoSupport")
public class HibernateDaoSupport {
    @Autowired
    private SessionFactory sessionFactory;
    protected org.apache.commons.logging.Log log = LogFactory.getLog(this.getClass());
    @Transactional(readOnly = true,propagation = Propagation.REQUIRED)
    public <T> T getOne(Class<T> clazz, Serializable id){
        return (T)getSession().get(clazz,id);
    }

    //获取一条记录
    public <T> T getOne(Class<T> clazz,String propName,Serializable propValue){
        Criteria criteria = getCriteria(clazz);
        criteria.add(Restrictions.eq(propName,propValue));
        return (T)criteria.uniqueResult();
    }

    //类和数据的映射
    @Transactional
    public <T> T getOneIgnoreFields(Class<T> clazz,String propName,Serializable propValue,String...propertyNames){
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(clazz);
        Criteria criteria = getCriteria(clazz);
        criteria.add(Restrictions.eq(propName,propValue));
        ProjectionList projectionList = Projections.projectionList();
        for (String property : classMetadata.getPropertyNames()) {
            projectionList.add(Projections.property(property));
        }
        criteria.setProjection(projectionList);
        return (T) criteria.uniqueResult();
    }

    //获取对象列表
    public <T>List<T> getList(Class<T> clazz){
        return getCriteria(clazz).list();
    }

    public <T>List<T> getList(Class<T> clazz, Order order){
        Criteria criteria = getCriteria(clazz);
        criteria.addOrder(order);
        return criteria.list();
    }

    public <T>List<T> getList(Class<T> clazz,String propName,Serializable propValue){
        Criteria criteria = getCriteria(clazz);
        criteria.add(Restrictions.eq(propName,propValue));
        return criteria.list();
    }

    public <T>List<T> getList(Class<T> clazz,String propName,Serializable propValue,Order order){
        Criteria criteria = getCriteria(clazz);
        criteria.add(Restrictions.eq(propName,propValue));
        criteria.addOrder(order);
        return criteria.list();
    }

    //SAVE
    public Serializable save(Object obj){
        Session session = getSession();
        Serializable result = session.save(obj);
        session.flush();
        return result;
    }

    //update
    public void update(Object obj) {
        Session session = getSession();
        session.update(obj);
        session.flush();
    }

    //有字段的更新
    public void updateWithFields(Object obj,String... propertyNames){
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(obj.getClass());
        Session session = getSession();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update ");
        stringBuilder.append(classMetadata.getEntityName());
        stringBuilder.append(" set");
        for (String propertyName : propertyNames) {
            stringBuilder.append(propertyName + "=:" + propertyName + ",");
        }
        //删除最后一个字段的逗号
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        //ID属性
        String idPropertyName = classMetadata.getIdentifierPropertyName();
        stringBuilder.append(" where " + idPropertyName + "=:" + idPropertyName);
        Query query = session.createQuery(stringBuilder.toString());
        query.setProperties(obj);
        query.executeUpdate();
        session.flush();
    }

    //
    public void updateIgnoreFields(Object object,String... propertyNames){
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(object.getClass());
        Session session = getSession();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update ");
        stringBuilder.append(classMetadata.getEntityName());
        stringBuilder.append(" set ");
        String[] allPropertyNames = classMetadata.getPropertyNames();
        for (String propertyName : allPropertyNames) {
            if (ArrayUtils.contains(propertyNames,propertyName)){
                continue;
            }
            else{
                stringBuilder.append(propertyName + "=:" + propertyName + ",");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        String idPropertyName = classMetadata.getIdentifierPropertyName();
        stringBuilder.append(" where " + idPropertyName + "=:" + idPropertyName);
        Query query = session.createQuery(stringBuilder.toString());
        query.setProperties(object);
        query.executeUpdate();
        session.flush();
    }

    //delete
    public void delete(Object object){
        Session session = getSession();
        session.delete(object);
        session.flush();
    }

    //条件删除
    public void delete(Class<?> clazz,String propName,Serializable propValue){
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(clazz);
        Session session = getSession();
        Query query = session.createQuery("delete from " + classMetadata.getEntityName() + " where " +
            propName + "=:" +propName);
        query.setParameter(propName,propValue);
        query.executeUpdate();
        session.flush();

    }
    public Criteria getCriteria(Class<?> clazz){
        return  getSession().createCriteria(clazz);
    }
    //获取Session对象
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    //设置session工厂类对象
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SQLQuery getSQLQuery(String sql){
        return getSession().createSQLQuery(sql);
    }

    public Query getQuery(String hql){
        return  getSession().createSQLQuery(hql);
    }
}
