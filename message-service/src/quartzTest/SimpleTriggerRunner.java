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
            System.out.println("任务开始....");
            scheduler.shutdown();
            System.out.println("任务结束");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
