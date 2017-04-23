package quartzTest;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by chen.Tian on 2017/4/9.
 */
public class SimpleTimeRunner {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new SimpletTimerTask("task");
        timer.schedule(task,1000L,1000L);//ÑÓ³Ù1Ãë£¬Ã¿¸ôÎåÃë
    }
}
