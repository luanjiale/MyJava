package MYFIRSTJAVA;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class SingleFileZip {
    public static void main(String[] args) throws IOException {
        ZipFile();
        UnZipFile();
    }

    //压缩方法
    public static void ZipFile() throws IOException {
        File f = new File("c:/temp/abc.txt");
        File zipfile = new File("c:/temp/single.zip");

        InputStream input = new FileInputStream(f);//定义文件输入流
        ZipOutputStream zipOut = null;//声明压缩流对象
        zipOut = new ZipOutputStream(new FileOutputStream(zipfile));
        zipOut.putNextEntry(new ZipEntry(f.getName()));//设置ZipEntry对象
        zipOut.setComment("single file zip.");//设置注释

        //压缩过程
        int temp = 0;
        while ((temp = input.read()) != -1) {//读取内容
            zipOut.write(temp);//压缩输出
        }
        input.close();
        zipOut.close();
    }

    //解压方法
    public static void UnZipFile() throws IOException {
        //待解压文件，从zip文件打开输入流，读取数据到java中
        File zipFile = new File("c:/temp/single.zip");
        ZipInputStream input = new ZipInputStream(new FileInputStream(zipFile));

        ZipEntry entry = input.getNextEntry();//得到一个压缩实体
        System.out.println("压缩实体名称： " + entry.getName());

        //新建目标文件，从目标文件打开输出流，数据从java输出
        File outFile = new File("c:/temp1/abc.txt");
        OutputStream output = new FileOutputStream(outFile);//实例化文件输出流
        int temp = 0;
        while ((temp = input.read()) != -1) {
            output.write(temp);
        }
        input.close();
        output.close();
        System.out.println("unzip done!");


    }
}
