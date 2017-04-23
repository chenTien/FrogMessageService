package concurrentInPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chen.Tian on 2017/4/17.
 */
public class CASDemo {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private static int i = 0;

    public static void main(String[] args) {
        final CASDemo casDemo = new CASDemo();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    casDemo.count();
                    casDemo.safeCount();
                }
            });
            ts.add(thread);
        }
        for (Thread t : ts) {
            t.start();
        }
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(casDemo.i);
        System.out.println(casDemo.atomicInteger.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    private void safeCount() {
        for (; ; ) {
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i, i++);
            if (suc) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }
}
