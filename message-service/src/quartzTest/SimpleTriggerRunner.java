package quartzTest;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by chen.Tian on 2017/4/9.
 */
public class SimpleTriggerRunner {
    public static void main(String[] args) {
        JobDetail jobDetail = new JobDetailImpl();

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            System.out.println("����ʼ....");
            scheduler.shutdown();
            System.out.println("�������");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
