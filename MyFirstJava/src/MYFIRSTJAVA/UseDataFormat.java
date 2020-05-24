package MYFIRSTJAVA;

import sun.util.resources.LocaleData;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UseDataFormat {
    public UseDataFormat(){
        System.out.println("------------------------------------");
        String DataStr="2020-5-22 22:05:45.341";
        String part1="yyyy-MM-dd hh:mm:ss.SSS";        //模板1,从字符串提取日期
        String part2="yyyy年MM月dd日hh时mm分ss秒SSS毫秒";//模板2，将日期转换为该模板
        SimpleDateFormat sdf1= new SimpleDateFormat(part1);
        SimpleDateFormat sdf2= new SimpleDateFormat(part2);
        Date d =null;
        Calendar cal= Calendar.getInstance();
        try {
            d = sdf1.parse(DataStr);
        }catch (Exception e){
            System.out.println("wrong!");
            e.printStackTrace();
        }
        Date w=new Date();
        System.out.println(cal.getTimeInMillis());
        for(int i=0;i<500000;i++){
            int a=0;
        }
        System.out.println(sdf2.format(d));
        System.out.println(cal.getWeekYear());
        System.out.println(cal.getTimeInMillis());

        //将获得现在得时间并转为字符串
        LocalDateTime ld= LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh时mm分ss秒SSS毫秒");
        String str1=ld.format(formatter);
        System.out.println(str1);
    }
}
