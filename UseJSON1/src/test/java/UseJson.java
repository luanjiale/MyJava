import org.json.JSONObject;

import java.util.Arrays;

public class UseJson {
    public static void main(String[] args) {
        testJsonObject();
        System.out.println("----------华丽丽的分割线----------");
        //testJsonFile();
    }

    private static void testJsonFile() {

    }

    private static void testJsonObject() {
        Preson p=new Preson();
        p.setAge(20);
        p.setName("Tom");
        p.setScores(Arrays.asList(90,85,67));

        //构造JSONObject对象
        JSONObject obj =new JSONObject();
        //String
        obj.put("name",p.getName());
        //int
        obj.put("age",p.getAge());
        //List
        obj.put("scores",p.getScores());
        System.out.println(obj);
        System.out.println("--------------------------");
        System.out.println("name: "+obj.getString("name"));
        System.out.println("age: "+obj.getInt("age"));
        System.out.println("scores: "+obj.getJSONArray("scores"));
    }
}
