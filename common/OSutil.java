package common;

/**
 * Created by chen.Tian on 2017/3/21.
 */
public class OSutil {

    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("win") > -1){
            isWindowsOS = true;
        }
        return isWindowsOS;
    }

    public static void main(String[] args) {
        System.out.println(OSutil.isWindowsOS());
    }
}
