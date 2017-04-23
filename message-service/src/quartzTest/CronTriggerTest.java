package quartzTest;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;

/**
 * Created by chen.Tian on 2017/4/11.
 */
public class CronTriggerTest {
    public static void main(String[] args) throws SchedulerException{
        //��ʼ��һ��Scheduler����
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        //����Schedulerʵ��
        Scheduler scheduler = schedulerFactory.getScheduler();
        //ͨ������job name, job group, and executable job class��ʼ��һ��JobDetail
        JobDetail jobDetail = new JobDetailImpl("jobDetail2","jobDetailGroup2",SimpleQuartzJob.class);
        //���ô��������ƺʹ���������������ʼ��һ��������
        CronTriggerImpl cronTrigger = new CronTriggerImpl("cronTrigger","triggerGroup2");
        //���ö�ʱ���Ĵ�������
        try {
            CronExpression cronExpression = new CronExpression("5-45 * * * * ?\"");
            //ע�ᴥ�����򵽴�������
            cronTrigger.setCronExpression(cronExpression);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //��������������JobDetai��Trigger
        scheduler.scheduleJob(jobDetail,cronTrigger);
        scheduler.start();
        //
    }
}
