import java.util.Locale;
import java.util.ResourceBundle;

public class Local_lang {
    public static void main(String[] args) {
        //取得系统默认的国家语言
        Locale lc=Locale.getDefault();
        System.out.println(lc);
        System.out.println(lc.getCountry());
        System.out.println(lc.getLanguage());

        //根据指定 语言_地区 加载资源环境
//        ResourceBundle bundle =ResourceBundle.getBundle("message",lc);
//
//        System.out.println(bundle.getString("hello"));

        lc=new Locale("en","US");//语言国家 强制转换为en_US
        ResourceBundle bundle=ResourceBundle.getBundle("message",lc);
        System.out.println(bundle.getString("hello"));
    }
}
