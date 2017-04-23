package concurrentUtils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chen.Tian on 2017/4/11.
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "������ˮA"; //  A¼��������ˮ����
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "������ˮB";
                    String A =  exgr.exchange(B);
                    System.out.println("A��B�������Ƿ�һ��: " + A.equals(B) + "A¼�����: " + A + "B¼�����: " + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}
