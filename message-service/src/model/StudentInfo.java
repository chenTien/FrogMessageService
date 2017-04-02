package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ѧ����Ϣ��
 * Created by chen.Tian on 2017/3/21.
 */
@Entity
@Table(name = "STUDENT_INFO")
public class StudentInfo {
    @Column(name = "STUDENT_NUMBER")
    private long studentNumber;//ѧ��
    @Column(name = "NAME")
    private String name;//����
    @Column(name = "SCHOOL_CODE")
    private int schoolCode;//ѧԺ����
    @Column(name = "BIRTH_DATE")
    private String birthdate;//��������
    @Column(name = "COURSE_ID")
    private int courseID;//�γ̱��

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
