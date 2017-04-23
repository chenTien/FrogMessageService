package translator;

import java.text.MessageFormat;

/**
 * �ļ�ת������׼�ӿ�
 * Created by chen.Tian on 2017/4/23.
 */
public interface FileTranslator {
    /**
     * ��ԭ�ļ���ʽת��Ŀ���ļ���ʽ
     *
     * @param sourceFileName Դ�ļ���
     * @param targetFileName Ŀ���ļ���
     * @param format         ��Ϣ��ʽ����
     */
    void translate(String sourceFileName, String targetFileName, MessageFormat format);
}
