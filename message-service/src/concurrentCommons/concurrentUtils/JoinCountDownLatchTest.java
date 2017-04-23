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
        parse1.join();  //join用于让当前执行线程等待join线程执行结束,原理是检查join是否存活,如果存活则让当前线程永远wait
        parse2.join();
        System.out.println("all parser finish...");
        //直到join线程中止后,线程的this.notifyAll会被执行,调用notifyAll是在JVM里面实现的,所以jdk里面看不到.
    }
}
