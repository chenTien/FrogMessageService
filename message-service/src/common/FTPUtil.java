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
     * Ftp������
     */
    private String server;
    /**
     * �û���
     */
    private String uname;
    /**
     * ����
     */
    private String password;
    /**
     * ���Ӷ˿ڣ�Ĭ��21
     */
    private int port = 21;

    public FTPUtil() {

    }

    /**
     * ����FTP������
     *
     * @param server   FTP������
     * @param port     �˿�
     * @param uname    �û���
     * @param password ����
     * @return ftpClient
     * @throws Exception
     */
    public FTPClient connectFTPServer(String server, int port, String uname,
                                      String password) throws Exception {
        //��ʼ������������Ϣ
        this.server = server;
        this.port = port;
        this.uname = uname;
        this.password = password;

        ftpClient = new FTPClient();

        try {
            ftpClient.configure(getFTPClientConfig());
            ftpClient.connect(this.server, this.port);
            ftpClient.login(this.uname, this.password);

            //�ļ����ͣ�Ĭ��ΪASCII
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//2ΪASCII

            //���ñ���ģʽ
            ftpClient.enterLocalPassiveMode();
            //���ó�ʱʱ��
            ftpClient.setConnectTimeout(2000);
            //���ñ����ʽ
            ftpClient.setControlEncoding("GBK");
            //��Ӧ��Ϣ
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                //�ر�����
                closeFTPClient();
                //�ͷſռ�
                ftpClient = null;
                throw new Exception("��¼ftp������ʧ�ܣ����飡[Server: " + server + "��" + "User: " + uname
                        + "��" + "Password: " + password);
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
     * ����FTP���Ӳ���
     *
     * @return config��������
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
     * �ϴ��ļ���FTP��Ŀ¼
     *
     * @param localFile �����ļ�
     * @param newName   ������
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
                throw new Exception("�ļ��ϴ�ʧ�ܣ�");
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
     * �ϴ��ļ���FTP��Ŀ¼
     *
     * @param inputStream ������
     * @param newName     ���ļ���
     * @throws Exception
     */
    public void uploadFile(InputStream inputStream, String newName) throws Exception {
        try {
            boolean result = ftpClient.storeFile(newName, inputStream);
            if (!result) {
                throw new Exception("�ļ��ϴ�ʧ�ܣ�");
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
     * �ϴ��ļ���ָ��Ŀ¼
     *
     * @param localFile      �����ļ�
     * @param newName        ���ļ���
     * @param remoteFoldPath ָ���ļ�·��
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

            //�ı䵱ǰ·����ָ��·��
            this.changeDirectory(remoteFoldPath);
            boolean result = ftpClient.storeFile(newName, inputStream);
            if (!result) {
                throw new Exception("�ļ��ϴ�ʧ�ܣ�");
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
     * �ϴ��ļ���ָ��FTP·��
     *
     * @param inputStream
     * @param newName
     * @param remoteFoldPath
     * @throws Exception
     */
    public void uploadFile(InputStream inputStream, String newName, String remoteFoldPath) throws Exception {
        //�ı䵱ǰ·����ָ��·��
        try {
            this.changeDirectory(remoteFoldPath);
            boolean result = ftpClient.storeFile(newName, inputStream);
            if (!result) {
                throw new Exception("�ļ��ϴ�ʧ�ܣ�");
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
     * ��FTPָ����·�������ļ�
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
                throw new Exception("�ļ�����ʧ�ܣ�");
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
     * ��FTPָ����·�������ļ�
     *
     * @param remotePath
     * @return
     * @throws IOException
     */
    public InputStream downLoadFile(String remotePath) throws IOException {
        return ftpClient.retrieveFileStream(remotePath);
    }

    /**
     * ��ȡFTP��������ָ��·���µ��ļ��б�
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
     * ��ȡFTP��������ָ��·���µ��ļ��б�
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
     * �г�FTP�������ļ��б���Ϣ
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
     * �ı乤��Ŀ¼����ʧ���򴴽��ļ���
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
     * ����ļ��Ƿ����
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public boolean checkFileExist(String filePath) throws Exception {
        boolean flag = false;
        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("�ļ������ڣ����飡");
        } else {
            flag = true;
        }
        return flag;
    }

    /**
     * ��ȡ�ļ����ƣ���������׺��
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
            //��ȡ�ļ����ĵ��֮ǰ������������׺�����ļ�����
            String _fileName = fileName.substring(0, fileName.indexOf("."));
            return _fileName;
        }
        return null;
    }

    /**
     * �ر�FTP����
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
            throw new Exception("�ر�FTP����ʧ�ܣ�");
        }
    }

    /**
     * �ر�FTP����
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
