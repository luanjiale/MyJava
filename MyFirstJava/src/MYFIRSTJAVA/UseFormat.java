package MYFIRSTJAVA;

import java.math.BigInteger;
import java.text.DecimalFormat;

class UseFormat {
    public UseFormat() {
        BigInteger a =new BigInteger("212131746467655");
        double b= 123412.00;
        DecimalFormat df1, df2,df3;
        df1 = new DecimalFormat("#.01");
        df2 = new DecimalFormat("#,###");
        df3 = new DecimalFormat("#,##0.00");
        System.out.println("----------------------------------------");
        System.out.println(df1.format(0.10));
        System.out.println(df3.format(b));
        System.out.println(df2.format(a));
    }
}