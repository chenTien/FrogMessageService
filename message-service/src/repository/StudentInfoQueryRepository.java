package repository;

import model.StudentInfo;

/**
 * Created by chen.Tian on 2017/3/21.
 */
public interface StudentInfoQueryRepository {

    /**
     * 根据学号查询学生信息
     * @param studentNumber 学生号
     * @return 学生信息
     */
    StudentInfo findStudentInfoByStudentNumber(int studentNumber);

    void saveStudentInfo(StudentInfo studentInfo);
}
