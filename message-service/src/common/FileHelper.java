package common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作帮助类
 * Created by chen.Tian on 2017/3/21.
 */
public class FileHelper {

    /**
     * 判断文件是否存在
     *
     * @param path 文件路径
     * @return 文件是否存在
     */
    public static boolean fileExist(String path) {
        File file = new File(path);
        return file.isFile() && file.exists();
    }

    /**
     * 判断目录是否存在
     *
     * @param path 目录路径
     * @return 目录是否存在
     */
    public static boolean dirExist(String path) {
        File dir = new File(path);
        return dir.isDirectory() && dir.exists();
    }

    /**
     * 创建指定目录，包括父目录
     *
     * @param path 目录路径
     */
    public static void createDir(String path) {
        try {
            File dir = new File(path);
            FileUtils.forceMkdir(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建目录
     *
     * @param path 目录路径
     * @throws IOException
     */
    public static void createDirIfNecessary(String path) throws IOException {
        String dir = FilenameUtils.getFullPath(path);
        if (!FileHelper.dirExist(dir)) {
            FileHelper.createDir(path);
        }
    }

    /**
     * 获取文件绝对路径
     *
     * @param path 文件路径
     * @return 文件绝对路径
     */
    public static String getAbsoutePath(String path) {
        File file = new File(path);
        return file.getAbsolutePath();
    }
}
