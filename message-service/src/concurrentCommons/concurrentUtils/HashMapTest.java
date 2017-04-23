package concurrentUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chen.Tian on 2017/4/12.
 */
public class HashMapTest {
    public static class MyRunnable implements Runnable {
        private Map<Integer,String> map = new HashMap<>();
        @Override
        public void run() {
            for (int i=0;i<1000;i++){
                map.put(i,""+System.currentTimeMillis());
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable sharedRunnable = new MyRunnable();
        Thread t1 = new Thread(sharedRunnable);
        Thread t2 = new Thread(sharedRunnable);
        t1.start();
        t2.start();
        System.out.println(sharedRunnable.map.size());
    }
}
