package concurrentInPractice;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by chen.Tian on 2017/4/17.
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(),"waitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(),"notifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            //����,ӵ��lock��monitor
            synchronized (lock) {
                //����������ʱ,����wait,ͬʱ�ͷ���lock����.
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + "flag is true, wait " + new SimpleDateFormat("HH: mm: ss").
                                format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //��������ʱ,��ɹ���
                System.out.println(Thread.currentThread() + "flag is false. Running " + new SimpleDateFormat("HH: mm: ss").
                        format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold back . notify @ " + new SimpleDateFormat("HH: mm: ss").
                        format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.sleep(5);
            }
            //�ٴμ���
            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock again. sleep at: " + new SimpleDateFormat("HH: mm: ss").
                        format(new Date()));
                SleepUtils.sleep(5);
            }
        }
    }
}
