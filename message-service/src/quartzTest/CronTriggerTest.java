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
        //初始化一个Scheduler工厂
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        //创建Scheduler实例
        Scheduler scheduler = schedulerFactory.getScheduler();
        //通过设置job name, job group, and executable job class初始化一个JobDetail
        JobDetail jobDetail = new JobDetailImpl("jobDetail2","jobDetailGroup2",SimpleQuartzJob.class);
        //设置触发器名称和触发器所属组名初始化一个触发器
        CronTriggerImpl cronTrigger = new CronTriggerImpl("cronTrigger","triggerGroup2");
        //设置定时器的触发规则
        try {
            CronExpression cronExpression = new CronExpression("5-45 * * * * ?\"");
            //注册触发规则到触发器中
            cronTrigger.setCronExpression(cronExpression);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //交给调度器运行JobDetai和Trigger
        scheduler.scheduleJob(jobDetail,cronTrigger);
        scheduler.start();
        //
    }
}
