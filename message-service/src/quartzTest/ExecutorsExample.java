package quartzTest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by chen.Tian on 2017/4/9.
 */
public class ExecutorsExample {
    private Executor executor;

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    //用执行器执行多个任务
    public void executeTask(){
        for (int i = 0; i <6 ; i++) {
            executor.execute(new SimpletTimerTask("task"+i));
        }
    }

    public static void main(String[] args) {
        ExecutorsExample example = new ExecutorsExample();
        example.setExecutor(Executors.newFixedThreadPool(2));
        example.executeTask();
    }
}
