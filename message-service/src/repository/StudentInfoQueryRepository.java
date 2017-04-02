package repository;

import model.StudentInfo;

/**
 * Created by chen.Tian on 2017/3/21.
 */
public interface StudentInfoQueryRepository {

    /**
     * ����ѧ�Ų�ѯѧ����Ϣ
     * @param studentNumber ѧ����
     * @return ѧ����Ϣ
     */
    StudentInfo findStudentInfoByStudentNumber(int studentNumber);

    void saveStudentInfo(StudentInfo studentInfo);
}
