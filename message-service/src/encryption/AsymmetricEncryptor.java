package encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * 非对称加密
 * Created by chen.Tian on 2017/4/3.
 */
public interface AsymmetricEncryptor {
    /**
     * 加密
     * @param publicKey 公钥
     * @param scrBytes  需要加密的字节数组
     * @return  密文
     */
    byte[] encrypt(RSAPublicKey publicKey, byte[] scrBytes) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException;

    /**
     * 解密
     * @param privateKey 私钥
     * @param scrBytes  需要解密的字节数组
     * @return  明文
     */
    byte[] decrypt(RSAPrivateKey privateKey,byte[] scrBytes) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException;
}
