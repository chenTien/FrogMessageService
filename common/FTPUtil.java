package common;


import org.apache.commons.net.ftp.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chen.Tian on 2017/3/22.
 */
public class FTPUtil {
    private FTPClient ftpClient = null;
    /**
     * Ftp服务器
     */
    private String server;
    /**
     * 用户名
     */
    private String uname;
    /**
     * 密码
     */
    private String password;
    /**
     * 连接端口，默认21
     */
    private int port = 21;

    public FTPUtil() {

    }

    /**
     * 连接FTP服务器
     *
     * @param server   FTP服务器
     * @param port     端口
     * @param uname    用户名
     * @param password 密码
     * @return ftpClient
     * @throws Exception
     */
    public FTPClient connectFTPServer(String server, int port, String uname,
                                      String password) throws Exception {
        //初始化，并保存信息
        this.server = server;
        this.port = port;
        this.uname = uname;
        this.password = password;

        ftpClient = new FTPClient();

        try {
            ftpClient.configure(getFTPClientConfig());
            ftpClient.connect(this.server, this.port);
            ftpClient.login(this.uname, this.password);

            //文件类型，默认为ASCII
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//2为ASCII

            //设置被动模式
            ftpClient.enterLocalPassiveMode();
            //设置超时时间
            ftpClient.setConnectTimeout(2000);
            //设置编码格式
            ftpClient.setControlEncoding("GBK");
            //响应信息
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                //关闭连接
                closeFTPClient();
                //释放空间
                ftpClient = null;
                throw new Exception("登录ftp服务器失败，请检查！[Server: " + server + "、" + "User: " + uname
                        + "、" + "Password: " + password);
            } else {
                return ftpClient;
            }
        } catch (Exception e) {
            ftpClient.disconnect();
            ftpClient = null;
            throw e;
        }
    }

    /**
     * 配置FTP连接参数
     *
     * @return config参数对象
     * @throws Exception
     */
    public FTPClientConfig getFTPClientConfig() throws Exception {
        String systemKey = FTPClientConfig.SYST_NT;//windows
        String serverLanguage = "zh";
        FTPClientConfig config = new FTPClientConfig(systemKey);
        config.setServerLanguageCode(serverLanguage);
        config.setDefaultDateFormatStr("yyyy-MM-dd");

        return config;
    }

    /**
     * 上传文件到FTP根目录
     *
     * @param localFile 本地文件
     * @param newName   新名称
     * @throws Exception
     */
    public void uploadFile(String localFile, String newName) throws Exception {
        InputStream inputStream = null;
        try {
            File file = null;
            if (checkFileExist(localFile)) {
                file = new File(localFile);
            }
            inputStream = new FileInputStream(file);
            boolean result = ftpClient.storeFile(newName, inputStream);
            if (!result) {
                throw new Exception("文件上传失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**
     * 上传文件到FTP根目录
     *
     * @param inputStream 输入流
     * @param newName     新文件名
     * @throws Exception
     */
    public void uploadFile(InputStream inputStream, String newName) throws Exception {
        try {
            boolean result = ftpClient.storeFile(newName, inputStream);
            if (!result) {
                throw new Exception("文件上传失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**
     * 上传文件到指定目录
     *
     * @param localFile      本地文件
     * @param newName        新文件名
     * @param remoteFoldPath 指定文件路径
     * @throws Exception
     */
    public void uploadFile(String localFile, String newName, String remoteFoldPath) throws Exception {
        InputStream inputStream = null;

        try {
            File file = null;
            if (checkFileExist(localFile)) {
                file = new File(localFile);
            }
            inputStream = new FileInputStream(file);

            //改变当前路径到指定路径
            this.changeDirectory(remoteFoldPath);
            boolean result = ftpClient.storeFile(newName, inputStream);
            if (!result) {
                throw new Exception("文件上传失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**
     * 上传文件到指定FTP路径
     *
     * @param inputStream
     * @param newName
     * @param remoteFoldPath
     * @throws Exception
     */
    public void uploadFile(InputStream inputStream, String newName, String remoteFoldPath) throws Exception {
        //改变当前路径到指定路径
        try {
            this.changeDirectory(remoteFoldPath);
            boolean result = ftpClient.storeFile(newName, inputStream);
            if (!result) {
                throw new Exception("文件上传失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**
     * 从FTP指定的路径下载文件
     *
     * @param remotePath
     * @param localPath
     * @throws Exception
     */
    public void downLoadFile(String remotePath, String localPath) throws Exception {
        OutputStream outputStream = null;
        try {
            File file = null;
            if (checkFileExist(localPath)) {
                file = new File(localPath);
            }
            outputStream = new FileOutputStream(file);
            boolean result = ftpClient.retrieveFile(remotePath, outputStream);
            if (!result) {
                throw new Exception("文件下载失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    /**
     * 从FTP指定的路径下载文件
     *
     * @param remotePath
     * @return
     * @throws IOException
     */
    public InputStream downLoadFile(String remotePath) throws IOException {
        return ftpClient.retrieveFileStream(remotePath);
    }

    /**
     * 获取FTP服务器上指定路径下的文件列表
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public List<String> getFtpServerFileList(String filePath) throws Exception {
        List<String> nlist = new ArrayList<String>();
        FTPListParseEngine engine = ftpClient.initiateListParsing(filePath);
        List<FTPFile> ftpFiles = Arrays.asList(engine.getNext(25));
        return getFTPServerFileList(nlist, ftpFiles);
    }

    /**
     * 获取FTP服务器上指定路径下的文件列表
     *
     * @param path
     * @return
     * @throws Exception
     */
    public List<String> getFileList(String path) throws Exception {
        List<String> nlist = new ArrayList<String>();
        List<FTPFile> ftpFiles = Arrays.asList(ftpClient.listFiles(path));
        return getFTPServerFileList(nlist, ftpFiles);
    }

    /**
     * 列出FTP服务器文件列表信息
     *
     * @param nlist
     * @param ftpFiles
     * @return
     */
    public List<String> getFTPServerFileList(List<String> nlist, List<FTPFile> ftpFiles) {
        if (ftpFiles == null || ftpFiles.size() == 0) {
            return nlist;
        }
        for (FTPFile ftpFile : ftpFiles) {
            if (ftpFile.isFile()) {
                nlist.add(ftpFile.getName());
            }
        }
        return nlist;
    }

    /**
     * 改变工作目录，如失败则创建文件夹
     *
     * @param remoteFoldPath
     * @throws Exception
     */
    public void changeDirectory(String remoteFoldPath) throws Exception {
        if (remoteFoldPath == null) {
            boolean flag = ftpClient.changeWorkingDirectory(remoteFoldPath);
            if (!flag) {
                ftpClient.makeDirectory(remoteFoldPath);
                ftpClient.changeWorkingDirectory(remoteFoldPath);
            }
        }
    }

    /**
     * 检查文件是否存在
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public boolean checkFileExist(String filePath) throws Exception {
        boolean flag = false;
        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("文件不存在，请检查！");
        } else {
            flag = true;
        }
        return flag;
    }

    /**
     * 获取文件名称，不包括后缀名
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public String getFileNamePrefix(String filePath) throws Exception {
        boolean flag = checkFileExist(filePath);
        if (flag) {
            File file = new File(filePath);
            String fileName = file.getName();
            //截取文件名的点号之前，即不包括后缀名的文件名称
            String _fileName = fileName.substring(0, fileName.indexOf("."));
            return _fileName;
        }
        return null;
    }

    /**
     * 关闭FTP服务
     *
     * @param ftpClient
     * @throws Exception
     */
    public void closeFTPClient(FTPClient ftpClient) throws Exception {
        try {
            if (ftpClient.isConnected()) {
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            throw new Exception("关闭FTP连接失败！");
        }
    }

    /**
     * 关闭FTP服务
     *
     * @throws Exception
     */
    public void closeFTPClient() throws Exception {
        this.closeFTPClient(this.ftpClient);
    }

    /**
     * get Abstract Method
     */
    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
