package quartzTest;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by chen.Tian on 2017/4/9.
 */
public class SimpletTimerTask extends TimerTask {
    private int count = 0;
    public SimpletTimerTask(String task){

    }
    @Override
    public void run() {
        System.out.println("execute task...");
        Date exeTime = new Date(scheduledExecutionTime());
        System.out.println("��������ִ�е�ʱ���Ϊ��" + exeTime);
        if (++count>10){
            cancel();
            System.out.println("����ִ�����...");
        }


    }
}
