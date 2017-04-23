package concurrentInPractice;

/**
 * Created by chen.Tian on 2017/4/17.
 */
public class DoubleCheckLockDemo {
    private volatile static DoubleCheckLockDemo doubleCheckLockDemo;
    private DoubleCheckLockDemo(){

    }

    public static DoubleCheckLockDemo getInstance(){
        if (doubleCheckLockDemo == null){
            synchronized (DoubleCheckLockDemo.class){
                if (doubleCheckLockDemo==null){
                    return new DoubleCheckLockDemo();
                }
            }
        }
        return doubleCheckLockDemo;
    }
}
