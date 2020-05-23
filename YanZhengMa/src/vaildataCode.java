import com.sun.deploy.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class vaildataCode {
    private static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'
            , 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static int charNum = codeSequence.length;
    private String ans="";

    public void MakeACode(String filePath) throws IOException {
        int Height = 100; //图片的高
        int Width = 300; //图片的宽
        BufferedImage bufimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_BGR);

        Graphics2D gd = bufimg.createGraphics();
        gd.setColor(Color.lightGray);
        gd.fillRect(0, 0, Width, Height);
        gd.setColor(Color.magenta);
        gd.drawRect(0, 0, Width - 1, Height - 3);
        //产生干扰线
        Random random = new Random();
        for (int i = 0; i < 60; i++) {
            int x = random.nextInt(Width);
            int y = random.nextInt(Height);
            int x1 = random.nextInt(90);
            int y1 = random.nextInt(80);
            int red= random.nextInt(255);
            int blue= random.nextInt(255);
            int green= random.nextInt(255);
            gd.setColor(new Color(red,blue,green));
            gd.drawLine(x,y,x+x1,y+y1);
        }
        //计算字的生成位置
        int countNum =4;
        int fontHeight=Height-20;
        int codeX=(Width-40)/(countNum+1);
        int codeY=55;
        Font font=new Font("Fixedsys",Font.PLAIN,fontHeight);
        gd.setFont(font);
        for(int i=0;i<countNum;i++){
            String strRand=String.valueOf(codeSequence[random.nextInt(charNum)]);
            ans=ans+strRand;
            int red= random.nextInt(255);
            int blue= random.nextInt(255);
            int green= random.nextInt(255);
            gd.setColor(new Color(red,blue,green));
            gd.drawString(strRand,25+(39*(i+1)+random.nextInt(4*(i+1))*(i+1)),random.nextInt(40)+codeY);//x按顺序，y在上下界限内随机
        }
        ImageIO.write(bufimg,"jpg",new File(filePath));
    }
    public boolean JudgeRight(String user){
        if(ans.compareToIgnoreCase(user)==0)
            return true;
        else
            return false;
    }
}
