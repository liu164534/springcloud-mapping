package com.mmz.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: spring-cloud-mapping
 * @description: 文件上传的通用工具类
 *      既然是通用的工具类，为什么不放到common工程？
 *         由于config依赖于common项目，如果把FTPUtils工具类放入到common项目
 *         意味着所有和ftp有关的jar包都会放入到common项目
 *         当consumer项目使用到common项目的时候，也会把common中有关ftp的jar包给引进
 *         这样会增加项目的负担，并且无法实现职责单一化
 * @author: Liu Xinpeng
 * @create: 2020-05-23 16:22
 **/
public class FTPUtils {
    /**
    * @Description: 私有构造方法防止被实例化
    * @Param: []
    * @return:
    * @Author: Liu Xinpeng
    * @Date: 2020/5/23
    */
    private FTPUtils() {
        throw new AssertionError();
    }

    /**
    * @Description: 文件上传的方法，返回值使用包装类型是为了防止NPE
     *      在进行文件上传之前，需要先连接到ftp服务器，也就是说需要先登陆到ftp
     *      进行文件上传的时候--必须知到文件所需要上传的路径
     *      (这里我们采用以当天日期为文件夹名称的方式对文件进行存放
     *      eg: 2020/02/02)
     *      还需要知到所要上传到的ftp服务器存放文件的根路径(/home/ftp)
     *      最后需要知到当前文件的名称
    * @Param: [host, port, username, password, filePath, basePath, fileName, inputStream]
    * @return: java.lang.Boolean
    * @Author: Liu Xinpeng
    * @Date: 2020/5/23
    */
//    public static Boolean uploadFile(String host, Integer port, String username, String password,
//                                      String filePath, String basePath, String fileName, InputStream inputStream)  {
//
//        // 1.创建一个临时的文件路径(在进行文件上传的时候，检测该日期文件夹是否存在，如果不存在就需要进行创建)
//        String tempPath = "";
//        // 2.创建FTPClient对象（这是ftp给java提供的API，可以实现连接ftp，登陆ftp,创建文件夹，实现文件的上传和下载。。)
//        FTPClient ftpClient = new FTPClient();
//        try{
//            // 3.连接ftp服务器
//            ftpClient.connect(host, port);
//            // 4.执行登陆操作   这一步在java中永远不会进入cache-->意思就是说不会捕获到异常信息
//            ftpClient.login(username, password);
//            // 5.验证是否成功的连接和登陆 （如果成功返回230，失败则返回503/530）
//            int replyCode = ftpClient.getReplyCode();
//            // 6.根据返回的状态码来判断用户是否已经连接和登陆成功
//            // isPositiveCompletion()  就是对状态码进行判断，成功返回true，失败返回false
//            if (! FTPReply.isPositiveCompletion(replyCode)) {
//                // 说明账号或者密码错误--》既然账号密码错误了，但是此时并不知道是否连接成功，如果连接成功了
//                // 需要断开连接释放资源，这里释放资源有可能会出现异常，所以在finally再执行一次，double check
//                ftpClient.disconnect();
//                return false;
//            }
//      // 7.此时说明连接和登陆都已经成功了，判断文件上传的路径是否存在
//      // changeWorkingDirectory(),该方法判断文件夹是否存在，存在返回true，不存在返回false
//      if (!ftpClient.changeWorkingDirectory(basePath + filePath)) {
//        // 路径不存在则需要创建文件夹，java没有类似mkdir -p 的级联创建命令，只能逐级进行创建
//        // 8.将文件路径进行分割
//        String[] dirs = filePath.split("/");
//        // 9.把basePath（/home/ftp）赋值给临时路径
//        tempPath = basePath;
//        // 10.对分割后的文件路径进行循环，创建文件夹
//        for (String dir : dirs) {
//          // 需要进行严谨性判断，保证文件夹的名称不能为null
//          // 跳出本次循环，进入下次循环
//          if (null == dir || "".equals(dir)) continue;
//          // 11.将临时路径和拆分的路径进行拼接  /home/ftp/2020
//          tempPath += "/" + dir;
//          // 12.再次检测来确保该文件夹不存在
//          if (!ftpClient.changeWorkingDirectory(tempPath)) {
//            // 13.创建文件夹
//            if (!ftpClient.makeDirectory(tempPath)) {
//              return false;
//            } else {
//              System.out.println("文件夹创建" + ftpClient.changeWorkingDirectory(tempPath));
//            }
//          }
//        }
//    }
//      // 14.说明文件夹存在，可以直接进行上传，FTP是支持IO的，但是IO的性能很低，所以将文件转换成二进制流进行上传
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//      // 15.这才是真实环境文件上传的方法 -- storeFile(), 返回值为true/false
//            if (! ftpClient.storeFile(fileName, inputStream)) {
//                return false;
//            }
//            // 16.关闭输入流
//            inputStream.close();
//            // 17.退出ftp
//            ftpClient.logout();
//        } catch (IOException ie) {
//            ie.printStackTrace();
//        } finally{
//            // 判断当前ftp是否处于连接状态
//            if (ftpClient.isConnected()) {
//                try{
//                    // 关闭ftp连接
//                    ftpClient.disconnect();
//                } catch (IOException ie) {
//                    ie.printStackTrace();
//                }
//            }
//
//        }
//        return true;
//    }

    public static Boolean uploadFile(String host, Integer port, String username, String password,
                                     String filePath, String basePath, String fileName, InputStream input) {

        // 1.创建临时路径(方便于后面我需要上传文件的时候，检测日期文件夹是否存在，如果不存在需要进行创建)
        // 2020-->2020/05--->2020/05/15(就是方便于拼接这个文件夹目录)
        String tmpPath = "";
        // 2.创建FTPClient对象(这也就是Ftp给java所提供的API，可以实现连接ftp，登录ftp，创建文件夹，实现文件上传和下载..)
        FTPClient ftp = new FTPClient();
        try {
            // 3.连接ftp服务器
            ftp.connect(host, port);
            // 4.执行登录操作
            ftp.login(username, password);// 这一步在java代码中永远不会进入cache
            // 5.验证服务器是否已经连接和登录成功(如果成功，则返回230，如果失败，则返回530/503)
            int reply = ftp.getReplyCode();
            // 6.根据返回的状态码来进行判断用户是否已经登录和连接成功
            // isPositiveCompletion():就是检测状态码的信息，如果成功返回true，如果失败返回false
            if(!FTPReply.isPositiveCompletion(reply)) {
                // 说明账号和密码错误(虽然已经知道账号密码错误，但是并不知道是否连接成功，如果连接成功了，需要及时断开连接(释放资源))
                ftp.disconnect();// 如果在这释放资源失败了
                return false;
            }

            // 如果没有进入if，就说明已经连接和登录成功了
            // 7.那么需要开始判断目标上传路径是否存在(/home/ftp/2020/05/15)
            // basePath + filePath---> /home/ftp/2020/05/15
            // changeWorkingDirectory():判断路径是否存在，如果存在返回true，如果不存在则返回false
            if(!ftp.changeWorkingDirectory(basePath + filePath)) {
                // 说明路径不存在，需要进行创建文件夹
                // java中可是没有mkdir -p命令的 mkdir -p /home/ftp/2020/05/15/，只能一层一层创建
                // 8.分割filePath--->String[] ---> ["", "2020", "05", "15"]
                String[] dirs = filePath.split("/");// "//"
                // 9.把basePath(/home/ftp)赋值给临时路径(tmpPath)
                tmpPath = basePath;
                // 10.循环dirs数组
                for(String dir : dirs) {
                    // 严谨判断 判断dir一定不能为null
                    if (null == dir || "".equals(dir)) continue;// 跳过本次循环，进入下一次循环
                    // 11.拼接临时路径
                    tmpPath += "/" + dir;// /home/ftp/2020
                    // 12.再次检测确保该路径不存在
                    if(!ftp.changeWorkingDirectory(tmpPath)) {
                        // 13.创建文件夹
                        // makeDirectory()--->就是创建文件夹的方法，返回为bolean
                        if(!ftp.makeDirectory(tmpPath)) {
                            return false;
                        } else {
                            System.out.println(ftp.changeWorkingDirectory(tmpPath));
                        }
                    }
                }
            }

            // 14.如果if没有进入，就说明这些文件夹都已经存在了，可以直接进行上传
            // FTP是支持IO的，但是IO的性能很低，所以可以使用二进制字符流的形式进行上传
            // 把文件转换为二进制字符流的模式来进行上传
            // 切换到被动模式
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 15.这才是真正实现文件上传的方法
            // storeFile():就是文件上传的方法，返回true/false
            if(!ftp.storeFile(fileName, input)) {
                return false;
            }
            // 16.关闭输入流
            input.close();
            // 17.退出ftp
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}