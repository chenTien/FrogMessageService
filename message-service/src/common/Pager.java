package common;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**分页查询工具类
 * Created by chen.Tian on 2017/3/19.
 */
public class Pager implements Serializable {
    private static final long serialVersionUID = 1L;
    //每页大小
    private int pageSize = 12;
    //当前页码
    private int pageNumber = 1;
    //总页数
    private int totalPage = 0;
    //显示记录起始
    private int rowFrom = 0;
    //显示记录结束
    private int rowTo = 0;
    //总记录数
    private int totalRows = 0;
    //数据
    private List data = new ArrayList();
    //参数
    private Map<String, Object> parameters = new HashMap<String,Object>();
    //排序字段
    private String orderBy = "modifyTime";
    //排序方式
    private String orderType = "desc";
    //排序类型
    private int sortId = 0;
    //排序耗时
    private long searchTime = 0;

    private boolean success = true;

    private String message;

    public Pager() {
        super();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize<1){
            this.pageSize = 1;
        }else if(pageSize > 100){
            this.pageSize = 100;
        }else {
            this.pageSize = pageSize;
        }
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        if(pageNumber<1){
            this.pageNumber=1;
        }else {
            this.pageNumber = pageNumber;
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRowFrom() {
        return rowFrom;
    }

    public void setRowFrom(int rowFrom) {
        this.rowFrom = rowFrom;
    }

    public int getRowTo() {
        return rowTo;
    }

    public void setRowTo(int rowTo) {
        this.rowTo = rowTo;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public long getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(long searchTime) {
        this.searchTime = searchTime;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public void removeParameters(String... keys){
        if((keys != null) && (keys.length > 0)){
            for (String key : keys) {
                parameters.remove(key);
            }
        }
    }

    public Long getLong(String key){
        if(parameters == null){
            return null;
        }

        Object object = parameters.get(key);
        if (object == null) {
            return null;
        }
        if(object instanceof Long){
            return (Long)object;
        } else {
            Long v = Long.parseLong(object.toString());
            return v;
        }

    }

    public Integer getInteger(String key) {
        if(parameters == null) {
            return null;
        }
        Object object = parameters.get(key);
        if(object == null){
            return null;
        }
        if(object instanceof Integer){
            return (Integer)object;
        }else {
            Integer v = Integer.parseInt(object.toString());
            return v;
        }
    }

    public String getString(String key) {
        if (parameters == null) {
            return null;
        }
        Object object = parameters.get(key);
        if (object == null){
            return null;
        }
        if (object instanceof String) {
            return (String)object;
        }
        else {
            return object.toString();
        }
    }
}