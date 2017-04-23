package quartzTest;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by chen.Tian on 2017/4/11.
 */
public class SimpleQuartzJob implements Job{
    public SimpleQuartzJob(){

    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("In SimpleQuartzJob - executing its job at " + new Date() + "by" +
                jobExecutionContext.getTrigger().getCalendarName());
    }
}
