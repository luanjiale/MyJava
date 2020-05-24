import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        REGEX1 regex1 =new REGEX1();
        REGEX2 regex2 =new REGEX2();
    }
}
class REGEX1{
    private static String REGEX1="\\bdog\\b";
    private static String matchs1="dog dog dog Dog dog doog ddog dogdog";
    public REGEX1(){
        //matcher 是完全匹配 与lookingAt 区别
        //pattern 是正则表达式的最小对象，由字符串编译来
        Pattern pa= Pattern.compile(REGEX1);
        // Mather 为匹配结果对象
        Matcher m = pa.matcher(matchs1);
        int count=0;
        while(m.find()){
            count++;
            // 调用 m 的方法
            System.out.println("Match Number "+count);
            System.out.println("start() "+m.start());
            System.out.println("end() "+m.end());
        }
        // System.out.println("NO");
    }
}

class REGEX2{
    private static  String REGEX2="[A-Z]";//a*b *表示限定前面的a可以有0个或多个
    private static  String INPUT="absaAGGGGGDRaaaaabaADDSaaaaabsfsadfooabfoobcddd";
    private static  String REPLACE="-";
    public REGEX2(){
        System.out.println("-------------------------------------------");
        Pattern p=Pattern.compile(REGEX2);
        Matcher matcher =p.matcher(INPUT);
        StringBuffer sbf=new StringBuffer();
        //全部替换
        while (matcher.find()){
            matcher.appendReplacement(sbf,REPLACE);//将匹配到的正则表达式全部替换，输出到sbf缓冲区中
        }
        matcher.appendTail(sbf);//加上末尾的cddd
        System.out.println(sbf.toString());
    }
}
