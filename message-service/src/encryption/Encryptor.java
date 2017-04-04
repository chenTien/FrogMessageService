package encryption;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/**
 * Created by chen.Tian on 2017/4/3.
 */
public interface Encryptor {
    /**
     * ����
     *
     * @param clearText ��Ҫ���ܵ��ַ���
     * @return �����ֽ�����
     */
    byte[] encrypt(String clearText) throws InvalidKeyException, GeneralSecurityException;

    /**
     * ����
     *
     * @param buffer �����ֽ�����
     * @return ����
     */
    byte[] decrypt(byte[] buffer) throws GeneralSecurityException;
}
