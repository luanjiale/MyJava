package MYFIRSTJAVA;

import java.io.File;
import java.io.IOException;

public class FileAttributeTest {
    public static void main(String[] args) {
        //创建目录
        File d =new File("c:/temp");
        if(!d.exists()){
            d.mkdir();//创建单级目录 mkdirs连续创建多级的目录
        }
        System.out.println("Is d directory?"+d.isDirectory());

        File f1 =new File("c:/temp/aaa.txt");
        if(!f1.exists()){
            try {
                f1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File f2 =new File("c:/temp/bbb.txt");
        if(!f2.exists()){
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Is f file? "+f1.isFile());
        System.out.println("Name: "+f1.getName());
        System.out.println("Parent: "+f1.getParent());
        System.out.println("Path: "+f1.getPath());
        System.out.println("Last modified time: "+f1.lastModified()+"ms");

        //遍历d下的文件信息
        System.out.println("list files in d directory");
        File[] fs=d.listFiles();
        for(File fl:fs){
            System.out.println(fl);
        }
        f1.delete();
        f2.delete();
        d.delete();
    }
}
