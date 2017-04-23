package concurrentUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量,用于做流量控制,特别是公共资源有限的场景
 * Created by chen.Tian on 2017/4/11.
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    //创建一个大小为30的线程池
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    //容量为10的资源,信号量,即最大并发为10
    private static Semaphore semaphore = new Semaphore(10);
    public static void main(String[] args) {
        for (int i=0;i<THREAD_COUNT;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//获取一个使用许可
                        Thread.currentThread().sleep(2000);
                        System.out.println("sava data");
                        semaphore.release();//使用完毕后释放许可证
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
