package concurrentInPractice;

/**
 * ���Բ�ͬ�������²����ʹ���Ч��,��Ҫ���ڲ����µ��������л�Ч��
 * Created by chen.Tian on 2017/4/17.
 */
public class CurrencyTest {
    private static final long count = 1_0000_0001;

    public static void main(String[] args) throws Exception {
        currency();
        serial();
    }

    //�����²���
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

    //�����²���
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
