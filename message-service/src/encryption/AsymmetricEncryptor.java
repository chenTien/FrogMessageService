package encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * �ǶԳƼ���
 * Created by chen.Tian on 2017/4/3.
 */
public interface AsymmetricEncryptor {
    /**
     * ����
     * @param publicKey ��Կ
     * @param scrBytes  ��Ҫ���ܵ��ֽ�����
     * @return  ����
     */
    byte[] encrypt(RSAPublicKey publicKey, byte[] scrBytes) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException;

    /**
     * ����
     * @param privateKey ˽Կ
     * @param scrBytes  ��Ҫ���ܵ��ֽ�����
     * @return  ����
     */
    byte[] decrypt(RSAPrivateKey privateKey,byte[] scrBytes) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException;
}
