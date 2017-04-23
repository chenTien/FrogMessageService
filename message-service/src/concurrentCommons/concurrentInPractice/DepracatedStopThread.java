package concurrentInPractice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * ���ڵ��ж�,����,ֹͣ�̷߳���
 * Created by chen.Tian on 2017/4/17.
 */
public class DepracatedStopThread {

    public static void main(String[] args) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        //��printThread�߳���ͣ,������ݹ���ֹͣ
        printThread.suspend();
        System.out.println("Main suspend PrintThread at " + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        //�ָ̻߳�,������ݼ���
        printThread.resume();
        System.out.println("Main resume PrintThread at " + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        //�߳���ֹ
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
