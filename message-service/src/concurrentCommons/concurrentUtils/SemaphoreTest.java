package concurrentUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * �ź���,��������������,�ر��ǹ�����Դ���޵ĳ���
 * Created by chen.Tian on 2017/4/11.
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    //����һ����СΪ30���̳߳�
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    //����Ϊ10����Դ,�ź���,����󲢷�Ϊ10
    private static Semaphore semaphore = new Semaphore(10);
    public static void main(String[] args) {
        for (int i=0;i<THREAD_COUNT;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//��ȡһ��ʹ�����
                        Thread.currentThread().sleep(2000);
                        System.out.println("sava data");
                        semaphore.release();//ʹ����Ϻ��ͷ����֤
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (Thread.activeCount()>0)
        threadPool.shutdown();
    }
}
