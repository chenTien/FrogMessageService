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
        //����һ��,mian�̶߳�CounterThread�����ж�,ʹCountThread�ܹ���֪�ж϶�����
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two,"CountThread");
        countThread.start();

        //����һ��,Main�̶߳�Runner two ����ȡ��,ʹCounterThread�ܹ���֪onΪfalse������
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
