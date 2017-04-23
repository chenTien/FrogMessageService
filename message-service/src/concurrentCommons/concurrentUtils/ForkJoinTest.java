package concurrentUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 使用Fork/join框架计算1+2+3+4
 * Created by chen.Tian on 2017/4/12.
 */
public class ForkJoinTest extends RecursiveTask {
    private static final int THREAD_HOLD = 2;//阈值
    private int start;
    private int end;

    public ForkJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Object compute() {
        int sum = 0;
        //如果任务足够小,就计算任务
        boolean canCompute = (end - start) <= THREAD_HOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阈值, 就分成两个子任务计算
            int middle = (start + end) / 2;
            ForkJoinTest leftTask = new ForkJoinTest(start, middle);
            ForkJoinTest rightTask = new ForkJoinTest(middle, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完,并得到执行结果
            int leftResult = (int) leftTask.join();
            int rightResult = (int) rightTask.join();
            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTest task = new ForkJoinTest(1, 4);
        //生成一个计算任务,负责计算1+2+3+4
        Future result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
