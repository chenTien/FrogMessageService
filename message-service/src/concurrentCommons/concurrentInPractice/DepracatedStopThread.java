package concurrentInPractice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 过期的中断,唤醒,停止线程方法
 * Created by chen.Tian on 2017/4/17.
 */
public class DepracatedStopThread {

    public static void main(String[] args) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        //将printThread线程暂停,输出内容工作停止
        printThread.suspend();
        System.out.println("Main suspend PrintThread at " + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        //线程恢复,输出内容继续
        printThread.resume();
        System.out.println("Main resume PrintThread at " + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        //线程终止
        printThread.stop();
        System.out.println("Main stop PrintThread at " + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName() + "Run at " + format.format(new Date()));
                SleepUtils.sleep(1);
            }
        }
    }
}
