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
    //KeyGenerator �ṩ�Գ���Կ�������Ĺ��ܣ�֧�ָ����㷨
    private KeyGenerator keygen;
    //SecretKey ���𱣴�Գ���Կ
    private SecretKey deskey;
    //Cipher������ɼ��ܻ���ܹ���
    private Cipher c;
    //���ֽ����鸺�𱣴���ܵĽ��
    private byte[] cipherByte;

    public CryptographyHelper(String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException {
        Security.addProvider(new SunJCE());
        //ʵ����֧��DES�㷨����Կ������(�㷨���������谴�涨�������׳��쳣)
        keygen = KeyGenerator.getInstance(algorithm);
        //������Կ
        deskey = keygen.generateKey();
        //����Cipher����
        c=Cipher.getInstance(algorithm);
    }

    @Override
    public byte[] encrypt(String clearText) throws InvalidKeyException,BadPaddingException,IllegalBlockSizeException {
        c.init(Cipher.ENCRYPT_MODE,deskey);
        // ������Կ����Cipher������г�ʼ����ENCRYPT_MODE��ʾ����ģʽ
        byte[] src = clearText.getBytes();
        cipherByte = c.doFinal(src);
        return cipherByte;
    }

    @Override
    public byte[] decrypt(byte[] buffer) throws InvalidKeyException,BadPaddingException,IllegalBlockSizeException {
        c.init(Cipher.DECRYPT_MODE,deskey);
        // ������Կ����Cipher������г�ʼ����ENCRYPT_MODE��ʾ����ģʽ
        cipherByte = c.doFinal(buffer);
        return cipherByte;
    }

    public static void main(String[] args) throws Exception{
        Encryptor desHelper = new CryptographyHelper("DESede");
        String msg ="��������������";
        byte[] encontent = desHelper.encrypt(msg);
        byte[] decontent = desHelper.decrypt(encontent);
        System.out.println(msg);//���� String
        System.out.println(new String(encontent));
        System.out.println(new String(decontent));
    }
}
