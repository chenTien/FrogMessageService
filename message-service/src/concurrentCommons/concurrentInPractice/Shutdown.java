package concurrentInPractice;

import java.util.concurrent.TimeUnit;

/**
 * Created by chen.Tian on 2017/4/17.
 */
public class Shutdown {
    public static void main(String[] args) throws Exception{
        Runner one = new Runner();
        Thread countThread = new Thread(one,"CountThread");
        countThread.start();
        //休眠一秒,mian线程对CounterThread进行中断,使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two,"CountThread");
        countThread.start();

        //休眠一秒,Main线程对Runner two 进行取消,使CounterThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i = " + i);
        }
        public void cancel(){
            on = false;
        }
    }
}
