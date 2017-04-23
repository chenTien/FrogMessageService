package concurrentUtils;

/**
 * Created by chen.Tian on 2017/4/12.
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        Mesage msg = new Mesage("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("All the threads are started");
    }

}