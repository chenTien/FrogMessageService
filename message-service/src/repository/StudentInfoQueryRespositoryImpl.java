package repository;

import common.HibernateDaoSupport;
import model.StudentInfo;
import org.hibernate.Query;

import javax.annotation.Resource;

/**
 * Created by chen.Tian on 2017/3/21.
 */
public class StudentInfoQueryRespositoryImpl implements StudentInfoQueryRepository{
    @Resource
    HibernateDaoSupport hibernateDaoSupport;
    @Override
    public StudentInfo findStudentInfoByStudentNumber(int studentNumber) {
       String hql = "from StudentInfo where studentNumber =:studentNumber ";
        Query query = hibernateDaoSupport.getQuery(hql);
        query.setInteger("studentNumber",studentNumber);
        return (StudentInfo)query.uniqueResult();
    }

    @Override
    public void saveStudentInfo(StudentInfo studentInfo) {
        hibernateDaoSupport.save(studentInfo);
    }
}
