package concurrentInPractice;

import java.util.concurrent.TimeUnit;

/**
 * Created by chen.Tian on 2017/4/17.
 */
public class Interrupted {
    public static void main(String[] args) throws Exception{
        //sleepThread��ͣ�ĳ���˯��
        Thread sleepThread = new Thread(new SleepRunner(),"Sleep thread...");
        sleepThread.setDaemon(true);//����Ϊ�ػ�����
        //BusyThread��ͣ������
        Thread busyThread = new Thread(new BusyRunner(),"Busy thread...");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();

        //����5��,�����̳߳������
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());    //false
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());  //true
        //��ֹ���߳������˳�
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
