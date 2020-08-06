package cn.test.controller;

import java.io.*;
/**
 * 数据字典相关
 * +-
 *
 * @author zgw
 * @create 2020-8-5
 **/
public class TestIo {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/zhu/Downloads/阿里巴巴Java开发手册（详尽版）.pdf");
        File file1 = new File("/Users/zhu/Downloads/sword5开发资料/test");
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream(file1);
        int i ;
        while (-1!=(i=is.read())){
            os.write(i);
        }
        os.close();
        is.close();
//        File file=new File("/Users/zhu/Downloads/sword5/Sword5学习/sword web API 5.2.9/版本说明.txt");
//        File file1=new File("/Users/zhu/Downloads111");
//        if(!file1.exists()){
//            System.out.println(file1.mkdirs());
//        }
//        System.out.println(file1.delete());
    }
}
