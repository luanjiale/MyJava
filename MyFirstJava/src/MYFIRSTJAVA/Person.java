package MYFIRSTJAVA;

import java.util.Arrays;

//person对象实现Comparable接口
//需要修改对象类
public class Person implements Comparable<Person> {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(Person another) {

/*      姓名优先的比较器
        int i=0;i=name.compareTo(another.name);//使用字符串的比较
        if(i==0){
            return age-another.age;
        }
        else{
            return i;
        }*/

        //年龄优先的比较器
        int n = 0;
        n = age - another.age;
        if (n == 0) {
            return name.compareTo(another.name);
        } else {
            return n;
        }
    }

    public static void main(String[] args) {
        Person[] ps = new Person[4];
        ps[0] = new Person(20, "Tom");
        ps[1] = new Person(12, "Mike");
        ps[2] = new Person(20, "Mike");
        ps[3] = new Person(21, "Aike");

        Arrays.sort(ps);
        for (Person p : ps) {
            System.out.println(p.getName() + " " + p.getAge());
        }
    }
}
