package encryption;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/**
 * Created by chen.Tian on 2017/4/3.
 */
public interface Encryptor {
    /**
     * 加密
     *
     * @param clearText 需要加密的字符串
     * @return 密文字节数组
     */
    byte[] encrypt(String clearText) throws InvalidKeyException, GeneralSecurityException;

    /**
     * 解密
     *
     * @param buffer 密文字节数组
     * @return 明文
     */
    byte[] decrypt(byte[] buffer) throws GeneralSecurityException;
}
