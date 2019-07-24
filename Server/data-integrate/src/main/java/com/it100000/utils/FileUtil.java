package com.it100000.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 文件工具类
 *
 * @author 杨新杰
 * @date 2019/7/1117:19
 */
public class FileUtil {

    public static void main(String[] args) {
        System.out.println(getRandomFileName());
    }

    /**
     * 生成随机文件名：当前年月日时分秒+五位随机数
     *
     * @return java.lang.String 返回随机文件名
     * @author 杨新杰
     * @date 2019/7/22 13:27
     **/
    public static String getRandomFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        // 获取5位随机数
        int ranNum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;
        // 当前时间
        return ranNum + str;
    }

    /**
     * 创建文件
     *
     * @param path 文件路径
     * @param fileName 文件名称
     * @return java.lang.String
     * @author 杨新杰
     * @date 2019/7/22 13:30
     **/
    public static String createNewFile(String path, String fileName) throws IOException {
        File file = new File(path + File.separator + fileName);
        if (file.createNewFile()){
            return path + File.separator + fileName;
        } else {
            return null;
        }
    }


    /**
     * 文件流写入文件
     *
     * @param file 文件流
     * @param path 文件存储路径
     * @return boolean
     * @author 杨新杰
     * @date   2019/7/22 13:34
     **/
    public static boolean writeFile(MultipartFile file, String path){

        return true;
    }

    /**
     * 文件读取写出
     *
     * @param file 文件对象
     * @param response 相应
     * @author 杨新杰
     * @date   2019/7/22 13:38
     **/
    public static void readFile(File file, HttpServletResponse response) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[fis.available()];
        OutputStream os = response.getOutputStream();
        os.write(b);
        os.flush();
        os.close();
        fis.close();

    }
}
