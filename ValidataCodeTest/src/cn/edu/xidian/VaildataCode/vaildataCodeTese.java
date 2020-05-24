package cn.edu.xidian.VaildataCode;

import com.sun.deploy.util.StringUtils;
import com.sun.xml.internal.fastinfoset.util.StringArray;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class vaildataCodeTese {
    static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'
            , 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static int charNum = codeSequence.length;

    public static void main(String[] args) throws IOException {
        generateCode("c:/temp/code.jpg");

    }
    private static void generateCode(String filePath) throws IOException {
        //定义验证码图片框
        int width = 800;
        int height = 230;
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        //定义图片上的图形和干扰线
        Graphics2D gd = buffImg.createGraphics();//画笔
        gd.setColor(Color.LIGHT_GRAY);//将图像填充为浅灰色
        gd.fillRect(0,0,width,height);
        gd.setColor(Color.BLACK);
        gd.drawRect(5,5,width-15,height-15);
        gd.setColor(Color.MAGENTA);
        //创建一个随机数生成器  用于随机产生干扰数
        Random random = new Random();
        for(int i=0;i<30;i++){
            int x=random.nextInt(width);
            int y=random.nextInt(height);
            int x1=random.nextInt(200);
            int y1=random.nextInt(120);
            gd.drawLine(x,y,x+x1,y+y1);
        }
        //计算字的生成位置坐标
        int codeCount=4;
        int fontHeight ;
        int CodeX;
        int CodeY;
        //width-4 移去左右多余的位置，使验证码更集中显示
        //codeCount+1 等比分配显示的宽度，包括左右两边的空格
        CodeX=(width-40)/(codeCount+1);//第一个字母的起始位置
        fontHeight=height-50;//高度中间区域显示验证码，fontheight 字体的大小
        CodeY=height-130;
        //创建字体,字体的大小应该根据图片的高度来定
        Font  font=new Font("Fixedsys",Font.PLAIN,fontHeight);
        gd.setFont(font);
        //随机产生codeCount数字的验证码,并记录
        String ans =new String("");
        for(int i=0;i<codeCount;i++){
            String strRand =String.valueOf(codeSequence[random.nextInt(charNum)]);
            ans=ans+strRand;
            int red=random.nextInt(255);
            int blue=random.nextInt(255);
            int green=random.nextInt(255);
            gd.setColor(new Color(red,blue,green));
            gd.drawString(strRand,(i+1)*CodeX,random.nextInt(100)+120);
        }
        ImageIO.write(buffImg,"jpg",new File(filePath));
        //System.out.println(ans);
        System.out.println("请输入验证码：");
        while(true) {
            Scanner in =new Scanner(System.in);
            String user=in.nextLine();
            if (ans.compareToIgnoreCase(user) == 0) {
                System.out.println("Right!");
                break;
            } else
                System.out.println("Wrong!");
        }
    }
}
