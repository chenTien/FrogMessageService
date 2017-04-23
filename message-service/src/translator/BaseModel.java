package translator;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chen.Tian on 2017/4/23.
 */
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = -1540252030447464140L;
    //������ID
    protected long id;
    //�������
    protected long orderIndex;
    //�޸�ʱ��
    protected Date modifyDate= new Date();
    //����״̬
    protected String manageStatus = "ACTIVE";
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(long orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getManageStatus() {
        return manageStatus;
    }

    public void setManageStatus(String manageStatus) {
        this.manageStatus = manageStatus;
    }
}
