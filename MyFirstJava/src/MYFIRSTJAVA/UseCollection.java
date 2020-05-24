package MYFIRSTJAVA;

import java.util.ArrayList;
import java.util.Collections;

public class UseCollection {
    public UseCollection(){
        ArrayList<Integer> list =new ArrayList<Integer>();
        list.add(1);
        list.add(13);
        list.add(122);
        list.add(12);
        list.add(156);
        list.add(121);
        //排序
        Collections.sort(list);
        for(Integer e :list){
            System.out.println(e);
        }
        System.out.println("元素所在索引值为："+ Collections.binarySearch(list,123));
        System.out.println("元素最大值： "+Collections.max(list));
        System.out.println("元素最小值： "+Collections.min(list));

    }
}
