package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**学院信息表
 * Created by chen.Tian on 2017/3/21.
 */
@Entity(name = "SCHOOL_INFO")
public class SchoolInfo {

    @Id
    @Column(name = "SCHOOL_CODE")
    private int schoolCode;//学院代码
    @Column(name = "SCHOOL_NAME")
    private String schoolName;//学院名称

    public int getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(int schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "SchoolInfo{" +
                "schoolCode=" + schoolCode +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
