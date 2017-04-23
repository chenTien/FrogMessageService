package concurrentInPractice;

import java.util.concurrent.TimeUnit;

/**
 * Created by chen.Tian on 2017/4/17.
 */
public class Interrupted {
    public static void main(String[] args) throws Exception{
        //sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(),"Sleep thread...");
        sleepThread.setDaemon(true);//设置为守护进程
        //BusyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(),"Busy thread...");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();

        //休眠5秒,让两线程充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());    //false
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());  //true
        //防止两线程立即退出
        SleepUtils.sleep(2);
    }

    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                SleepUtils.sleep(10);
            }
        }
    }

    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){

            }
        }
    }
}
