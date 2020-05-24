package MYFIRSTJAVA;

import java.io.*;

public class BinFileWrite {
    public static void main(String[] args) {
        writeFile();
    }

    public static void writeFile(){
        File d=new File("c:/temp");
        if(!d.exists()){
            d.mkdir();
        }
        File f=new File("def.dat");
        if(!f.exists()){
            try {
                f.createNewFile();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        /*
          节点类：负责写字节
          装饰类：将字节数据写入缓冲区
          转化类：负责数据类型到字节转化
         */
        //写文件
        try(DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("c:/temp/def.dat")))){
            dos.writeUTF("a");
            dos.writeInt(20);
            dos.writeBoolean(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        try(DataInputStream dos=new DataInputStream(new BufferedInputStream(new FileInputStream("c:/temp/def.dat")))){
            System.out.println(dos.readUTF());
            System.out.println(dos.readInt());
            System.out.println(dos.readBoolean());

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
