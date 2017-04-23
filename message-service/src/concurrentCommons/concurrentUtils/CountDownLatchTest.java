package concurrentUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by chen.Tian on 2017/4/11.
 */
public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                countDownLatch.countDown();
                System.out.println(2);
//                countDownLatch.countDown();
//                try {
//                    Thread.sleep(3000);
//                    countDownLatch.countDown();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();
        countDownLatch.await(1, TimeUnit.SECONDS);
        System.out.println("3");
    }
}
