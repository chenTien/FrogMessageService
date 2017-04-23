package concurrentInPractice;

/**
 * Created by chen.Tian on 2017/4/17.
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();//main线程启动了DaemonRunner后,main方法执行完毕,虚拟机退出
    }

    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("DaemonThread finally run.");//不会执行
            }
        }
    }
}
