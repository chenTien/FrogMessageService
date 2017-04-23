package quartzTest;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by chen.Tian on 2017/4/9.
 */
public class SimpletTimerTask extends TimerTask {
    private int count = 0;
    public SimpletTimerTask(String task){

    }
    @Override
    public void run() {
        System.out.println("execute task...");
        Date exeTime = new Date(scheduledExecutionTime());
        System.out.println("本次任务执行的时间点为：" + exeTime);
        if (++count>10){
            cancel();
            System.out.println("任务执行完毕...");
        }


    }
}
