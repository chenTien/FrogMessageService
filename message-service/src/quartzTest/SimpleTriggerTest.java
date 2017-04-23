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
        //初始化一个schedule工厂
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        //通过schedule工厂类获得一个Schedule类
        Scheduler scheduler = schedulerFactory.getScheduler();
        //通过job name，job group, and executable job class初始化一个jobDetail
        JobDetail jobDetail = new JobDetailImpl("jobDetail-s1","jobDetailGroup",SimpleQuartzJob.class);
        //设置触发器名称和触发器所属组名初始化一个触发器
        SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl("simpleTrigger","triggerGroup1");
        //获取当前时间，初始化触发器开始日期
        long ctime = System.currentTimeMillis();
        simpleTrigger.setStartTime(new Date(ctime));
        //设置触发时间间隔 10秒
        simpleTrigger.setRepeatInterval(10000);
        //设置触发器运行次数，完成后退出
        simpleTrigger.setRepeatCount(100);
        //交给调度器调度运行JobDetail和Trigger
        scheduler.scheduleJob(jobDetail,simpleTrigger);
        scheduler.start();
    }
}
