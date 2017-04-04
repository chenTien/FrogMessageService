package encryption;

import com.sun.crypto.provider.SunJCE;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * Created by chen.Tian on 2017/4/3.
 */
public class CryptographyHelper implements Encryptor{
    //KeyGenerator 提供对称密钥生成器的功能，支持各种算法
    private KeyGenerator keygen;
    //SecretKey 负责保存对称密钥
    private SecretKey deskey;
    //Cipher负责完成加密或解密工作
    private Cipher c;
    //该字节数组负责保存加密的结果
    private byte[] cipherByte;

    public CryptographyHelper(String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException {
        Security.addProvider(new SunJCE());
        //实例化支持DES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)
        keygen = KeyGenerator.getInstance(algorithm);
        //生成密钥
        deskey = keygen.generateKey();
        //生成Cipher对象
        c=Cipher.getInstance(algorithm);
    }

    @Override
    public byte[] encrypt(String clearText) throws InvalidKeyException,BadPaddingException,IllegalBlockSizeException {
        c.init(Cipher.ENCRYPT_MODE,deskey);
        // 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
        byte[] src = clearText.getBytes();
        cipherByte = c.doFinal(src);
        return cipherByte;
    }

    @Override
    public byte[] decrypt(byte[] buffer) throws InvalidKeyException,BadPaddingException,IllegalBlockSizeException {
        c.init(Cipher.DECRYPT_MODE,deskey);
        // 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
        cipherByte = c.doFinal(buffer);
        return cipherByte;
    }

    public static void main(String[] args) throws Exception{
        Encryptor desHelper = new CryptographyHelper("DESede");
        String msg ="苟利国家生死以";
        byte[] encontent = desHelper.encrypt(msg);
        byte[] decontent = desHelper.decrypt(encontent);
        System.out.println(msg);//密文 String
        System.out.println(new String(encontent));
        System.out.println(new String(decontent));
    }
}
