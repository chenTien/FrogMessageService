package concurrentUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * ʹ��Fork/join��ܼ���1+2+3+4
 * Created by chen.Tian on 2017/4/12.
 */
public class ForkJoinTest extends RecursiveTask {
    private static final int THREAD_HOLD = 2;//��ֵ
    private int start;
    private int end;

    public ForkJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Object compute() {
        int sum = 0;
        //��������㹻С,�ͼ�������
        boolean canCompute = (end - start) <= THREAD_HOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //������������ֵ, �ͷֳ��������������
            int middle = (start + end) / 2;
            ForkJoinTest leftTask = new ForkJoinTest(start, middle);
            ForkJoinTest rightTask = new ForkJoinTest(middle, end);
            //ִ��������
            leftTask.fork();
            rightTask.fork();
            //�ȴ�������ִ����,���õ�ִ�н��
            int leftResult = (int) leftTask.join();
            int rightResult = (int) rightTask.join();
            //�ϲ�������
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTest task = new ForkJoinTest(1, 4);
        //����һ����������,�������1+2+3+4
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
