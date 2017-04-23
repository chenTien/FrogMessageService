package translator;

import java.text.MessageFormat;

/**
 * 文件转换器标准接口
 * Created by chen.Tian on 2017/4/23.
 */
public interface FileTranslator {
    /**
     * 从原文件格式转到目标文件格式
     *
     * @param sourceFileName 源文件名
     * @param targetFileName 目标文件名
     * @param format         消息格式定义
     */
    void translate(String sourceFileName, String targetFileName, MessageFormat format);
}
