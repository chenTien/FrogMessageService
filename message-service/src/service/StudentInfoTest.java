package service;

import model.StudentInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.StudentInfoQueryRepository;

/**
 * Created by chen.Tian on 2017/3/21.
 */
public class StudentInfoTest {

//    @Resource
//    private StudentInfoQueryRepository studentInfoQueryRepository;
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    //        NewsDao dao = (NewsDao)ctx.getBean("newsDaoTrans",NewsDao.class);
    StudentInfoQueryRepository studentInfoQueryRepository = (StudentInfoQueryRepository)context.getBean(StudentInfoQueryRepository.class);
    public void execute(){
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudentNumber(1302080227);
        studentInfo.setBirthdate("19901014");
        studentInfo.setName("TIANCHEN");
        studentInfo.setCourseID(2);
        studentInfoQueryRepository.saveStudentInfo(studentInfo);
    }
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        NewsDao dao = (NewsDao)ctx.getBean("newsDaoTrans",NewsDao.class);
//        StudentInfoQueryRepository studentInfoQueryRepository = (StudentInfoQueryRepository)context.getBean(StudentInfoQueryRepository.class);
        new StudentInfoTest().execute();
    }
}
