package concurrentUtils;

/**
 * Created by chen.Tian on 2017/4/17.
 */
public class VolitaleTest {
    public static void main(String[] args) {
      Vrun one = new Vrun();
      Thread t1 = new Thread(one,"vrun");
      Thread t2 = new Thread(one,"vrun");
      t1.start();
      t2.start();
    }

    static class Vrun implements Runnable {
        private volatile long count;
        @Override
        public void run() {
            for (int i = 0; i < 100_0000; i++) {
                count++;
            }
            System.out.println(count);
        }
    }
}
