package quartzTest;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by chen.Tian on 2017/4/9.
 */
public class SimpleJob implements Job{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(jobExecutionContext.getTrigger().getCalendarName());
    }
}
