package concurrentInPractice;

/**
 * 测试不同数据量下并发和串行效率,主要在于并发下的上下文切换效率
 * Created by chen.Tian on 2017/4/17.
 */
public class CurrencyTest {
    private static final long count = 1_0000_0001;

    public static void main(String[] args) throws Exception {
        currency();
        serial();
    }

    //并行下测试
    private static void currency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("currency :" + time + "ms,b= " + b);
    }

    //串行下测试
    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial :" + time + "ms,b= " + b);
    }
}
