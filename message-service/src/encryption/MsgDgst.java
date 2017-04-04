package encryption;

import java.security.NoSuchAlgorithmException;

/**
 * Created by chen.Tian on 2017/4/3.
 */
public interface MsgDgst {
    byte[] encrypt(byte[] data) throws NoSuchAlgorithmException;
}
