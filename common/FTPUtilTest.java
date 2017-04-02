package common;

/**
 * Created by chen.Tian on 2017/3/22.
 */
public class FTPUtilTest {
    public static void main(String[] args) {
        try {
            FTPUtil ftpUtil = new FTPUtil();
            ftpUtil.connectFTPServer("127.0.0.1",21,"","");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("“Ï≥£–≈œ¢£∫" +e.getMessage());
        }
    }
}
