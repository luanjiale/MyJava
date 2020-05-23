import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Frame {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入验证码： ");
        vaildataCode vdc1=new vaildataCode();
        File d= new File("c:/temp");
        if(!d.exists()){
            try {
                d.mkdir();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        File f= new File("c:/temp/code.jpg");
        if(!f.exists()){
            try {
                d.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        vdc1.MakeACode("c:/temp/code.jpg");
        Scanner in =new Scanner(System.in);
        String user= in.nextLine();
        while(!vdc1.JudgeRight(user)){
            System.out.println("Wrong! Please try again.");
            Scanner in1 =new Scanner(System.in);
             user= in.nextLine();
        }
        System.out.println("You are Right");
    }
}
