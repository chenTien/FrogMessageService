package concurrentInPractice;

/**
 * Created by chen.Tian on 2017/4/17.
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               synchronized (A){
                   try {
                       Thread.currentThread().sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }synchronized (B){
                       System.out.println("1");
                   }
               }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                   synchronized (A){
                       System.out.println("2");
                   }
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }
}
