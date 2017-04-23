package concurrentInPractice;

/**
 * Created by chen.Tian on 2017/4/17.
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();//main�߳�������DaemonRunner��,main����ִ�����,������˳�
    }

    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("DaemonThread finally run.");//����ִ��
            }
        }
    }
}
