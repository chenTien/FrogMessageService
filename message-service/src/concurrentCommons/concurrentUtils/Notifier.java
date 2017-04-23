package concurrentUtils;

/**
 * Created by chen.Tian on 2017/4/12.
 */
public class Notifier implements Runnable {

    private Mesage msg;

    public Notifier(Mesage msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(name+" Notifier work done");
                msg.notify();
                // msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}