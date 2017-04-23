package concurrentUtils;

/**
 * Created by chen.Tian on 2017/4/11.
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException{
        Thread parse1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parse1 finish...");
            }
        });

        Thread parse2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parse2 finish...");
            }
        });

        parse1.start();
        parse2.start();
        parse1.join();  //join�����õ�ǰִ���̵߳ȴ�join�߳�ִ�н���,ԭ���Ǽ��join�Ƿ���,���������õ�ǰ�߳���Զwait
        parse2.join();
        System.out.println("all parser finish...");
        //ֱ��join�߳���ֹ��,�̵߳�this.notifyAll�ᱻִ��,����notifyAll����JVM����ʵ�ֵ�,����jdk���濴����.
    }
}
