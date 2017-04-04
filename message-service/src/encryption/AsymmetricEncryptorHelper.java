package encryption;

import common.Constants;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Created by chen.Tian on 2017/4/3.
 */
public class AsymmetricEncryptorHelper implements AsymmetricEncryptor {
    private String algorithm;

    public AsymmetricEncryptorHelper(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * RSA����
     *
     * @param publicKey ��Կ
     * @param scrBytes  ��Ҫ���ܵ��ֽ�����
     * @return ����
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    @Override
    public byte[] encrypt(RSAPublicKey publicKey, byte[] scrBytes) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (publicKey != null) {
            //Cipher������ɼ��ܻ���ܹ���������RSA
            Cipher cipher = Cipher.getInstance(algorithm);
            //��ʼ��Cipher����
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] resultBytes = cipher.doFinal(scrBytes);
            return resultBytes;
        }
        return null;
    }

    /**
     * RSA����
     *
     * @param privateKey ˽Կ
     * @param scrBytes   ��Ҫ���ܵ��ֽ�����
     * @return ����
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    @Override
    public byte[] decrypt(RSAPrivateKey privateKey, byte[] scrBytes) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (privateKey != null) {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] resultBytes = cipher.doFinal(scrBytes);
            return resultBytes;
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        AsymmetricEncryptor asymmetricEncryptor = new AsymmetricEncryptorHelper(Constants.RSA);
        String msg = "�����������֮";
        byte[] srcBytes = msg.getBytes();
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        byte[] enContent = asymmetricEncryptor.encrypt(publicKey,srcBytes);
        byte[] deContent = asymmetricEncryptor.decrypt(privateKey,enContent);
        String clearText = new String(deContent);
        System.out.println(msg);
        System.out.println(new String(enContent));
        System.out.println(clearText);
    }
}
