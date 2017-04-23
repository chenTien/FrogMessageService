package quartzTest;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.util.Date;

/**
 * Created by chen.Tian on 2017/4/11.
 */
public class SimpleTriggerTest {
    public static void main(String[] args) throws SchedulerException{
        //��ʼ��һ��schedule����
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        //ͨ��schedule��������һ��Schedule��
        Scheduler scheduler = schedulerFactory.getScheduler();
        //ͨ��job name��job group, and executable job class��ʼ��һ��jobDetail
        JobDetail jobDetail = new JobDetailImpl("jobDetail-s1","jobDetailGroup",SimpleQuartzJob.class);
        //���ô��������ƺʹ���������������ʼ��һ��������
        SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl("simpleTrigger","triggerGroup1");
        //��ȡ��ǰʱ�䣬��ʼ����������ʼ����
        long ctime = System.currentTimeMillis();
        simpleTrigger.setStartTime(new Date(ctime));
        //���ô���ʱ���� 10��
        simpleTrigger.setRepeatInterval(10000);
        //���ô��������д�������ɺ��˳�
        simpleTrigger.setRepeatCount(100);
        //������������������JobDetail��Trigger
        scheduler.scheduleJob(jobDetail,simpleTrigger);
        scheduler.start();
    }
}
