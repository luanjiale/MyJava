package MYFIRSTJAVA;

import java.io.*;

public class TxtFileWrite {

    public static void main(String[] args) {
        writeFile();
    }
    //成员方法
    public static void writeFile(){
        File d=new File("c:/temp");
        if(!d.exists()){
            d.mkdir();
        }
        File f=new File("c:/temp/abc.txt");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写文件
        FileOutputStream fos =null;
        OutputStreamWriter osw=null;
        BufferedWriter bw =null;
        try {
            fos=new FileOutputStream("c:/temp/abc.txt");//节点类
            osw=new OutputStreamWriter(fos,"UTF-8");//转化类
            //osw=new OutputStreamWriter(fos)
            bw=new BufferedWriter(osw);//装饰类
            bw.write("我们是： ");
            bw.newLine();
            bw.write("Ecnuers.^^");
            bw.newLine();
            bw.write("欢迎打开！");
            bw.newLine();
            bw.write("我要关闭了");
            bw.newLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                bw.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        //读文件
//        FileInputStream fip=null;
//        InputStreamReader isr =null;
//        BufferedReader br =null;
        String line;
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("c:/temp/abc.txt"),"UTF-8"))){
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        f.delete();
        d.delete();
    }
}
