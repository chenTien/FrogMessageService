package concurrentInPractice;

/**
 * �߳����߹�����
 * Created by chen.Tian on 2017/4/17.
 */
public class SleepUtils {
    public static void sleep(int seconds){
        try {
            Thread.currentThread().sleep(seconds*10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
