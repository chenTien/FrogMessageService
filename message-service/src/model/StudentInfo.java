package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 学生信息表
 * Created by chen.Tian on 2017/3/21.
 */
@Entity
@Table(name = "STUDENT_INFO")
public class StudentInfo {
    @Column(name = "STUDENT_NUMBER")
    private long studentNumber;//学号
    @Column(name = "NAME")
    private String name;//姓名
    @Column(name = "SCHOOL_CODE")
    private int schoolCode;//学院代码
    @Column(name = "BIRTH_DATE")
    private String birthdate;//出生年月
    @Column(name = "COURSE_ID")
    private int courseID;//课程编号

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(int schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "studentNumber=" + studentNumber +
                ", name='" + name + '\'' +
                ", schoolCode=" + schoolCode +
                ", birthdate='" + birthdate + '\'' +
                ", courseID=" + courseID +
                '}';
    }
}
