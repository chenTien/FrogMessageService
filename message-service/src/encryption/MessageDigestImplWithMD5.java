package encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by chen.Tian on 2017/4/3.
 */
public class MessageDigestImplWithMD5 implements MsgDgst{
    /**
     * MD5加密
     * @param data
     * @return
     * @throws NoSuchAlgorithmException
     */
    @Override
    public byte[] encrypt(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(data);
        return md5.digest();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MsgDgst msgDgst = new MessageDigestImplWithMD5();
        String msg = "三个代表";
        byte[] srcBytes = msg.getBytes();
        String deContent = new String(msgDgst.encrypt(srcBytes));
        System.out.println(new String(deContent));
    }
}
