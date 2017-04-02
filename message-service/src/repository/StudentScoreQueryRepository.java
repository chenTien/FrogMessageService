package repository;

/**
 * Created by chen.Tian on 2017/3/21.
 */
public interface  StudentScoreQueryRepository {
    //根据课程号查询课程成绩
    void findScoreByScoreID(int scoreId);
}
