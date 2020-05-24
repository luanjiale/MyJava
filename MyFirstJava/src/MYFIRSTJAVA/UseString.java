package MYFIRSTJAVA;

import java.util.Calendar;

class UseString{
    public UseString() {
        /*
        String为不可变对象，定义之后就没法再改变，例如膨胀删减，但StringBUffer/StringBuilder可以
         */
        String str = "123,321;4,32!of,sk ";
        StringBuffer strB1 = new StringBuffer("213adw;awfdsa,awfawd'afwadaw.awdfafw?f1!");
        StringBuffer strB2 = strB1;
        //strB2相当于指向strB1的指针，并不是实际对象
        System.out.println(str.charAt(0));
        System.out.println(str.indexOf(","));
        System.out.println(str.concat(";000"));//末尾加入字符串并返回，但元字符串不变
        System.out.println(str);
        System.out.println(str.contains("432"));
        System.out.println(str.endsWith("k"));
        System.out.println(str.equals("000"));
        System.out.println(str.equalsIgnoreCase(" 123,321;432!OFSk "));//忽略大小写
        System.out.println(str.length());
        System.out.println(str.trim());//返回出除去前后空格的字符串，str不变
        String[] sArray = str.split(";");//按;将字符串分隔开
        for (String e : sArray) {
            System.out.println(e);
        }
        System.out.println("---------------------------------------------------");
        System.out.println(str.replace(",", "?"));
        System.out.println(str.replaceAll("[0-2|,]", "?"));//使用正则表达式替换
        System.out.println("---------------------------------------------------");
        strB1.append("adsafasdaasfasda");
        strB2.append("123");
        System.out.println(strB1);
        System.out.println(strB2);
        Calendar t1 = Calendar.getInstance();
        for (int i = 0; i < 500000; i++) {
            strB1.append(",");
        }
        Calendar t2 = Calendar.getInstance();
        StringBuilder sb1 = new StringBuilder("adsafasdasfa");
        Calendar t3 = Calendar.getInstance();
        for (int i = 0; i < 500000; i++) {
            sb1.append(",");
        }
        Calendar t4 = Calendar.getInstance();
        Calendar t5 = Calendar.getInstance();
        for (int i = 0; i < 50000; i++) {
            str = str + ",";
        }
        Calendar t6 = Calendar.getInstance();
        System.out.println(t2.getTimeInMillis() - t1.getTimeInMillis());
        System.out.println(t4.getTimeInMillis() - t3.getTimeInMillis());
        System.out.println(t6.getTimeInMillis() - t5.getTimeInMillis());
        //StringBuilder Faster than StringBuffer !
        //StringBuffer Faster than String !
    }
}