package concurrentInPractice;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by chen.Tian on 2017/4/17.
 */
public class MultiThread {
    public static void main(String[] args) {
        //��ȡJava�̹߳���MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //����Ҫ��ȡͬ����monitor��synchronizer��Ϣ,����ȡ�̺߳��̵߳Ķ�ջ��Ϣ
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        //�����߳�,����ӡ�߳�ID���߳�����
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}
