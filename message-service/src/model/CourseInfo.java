package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**课程信息表
 * Created by chen.Tian on 2017/3/21.
 */
@Entity
@Table(name = "COURSE_INFO")
public class CourseInfo {
    @Column(name = "COURSE_ID")
    private int courseID;//课程号
    @Column(name = "COURSE_NAME")
    private String courseName;//课程名
    @Column(name = "SCHOOL_CODE")
    private String school_code;//所属院系代码

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSchool_code() {
        return school_code;
    }

    public void setSchool_code(String school_code) {
        this.school_code = school_code;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", school_code='" + school_code + '\'' +
                '}';
    }
}
