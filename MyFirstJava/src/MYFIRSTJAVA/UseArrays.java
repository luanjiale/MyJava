package MYFIRSTJAVA;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class UseArrays {
    public UseArrays(){
        System.out.println("----------------------------");
        int[] a=new int[10];
        Random r=new Random() ;
        for(int i=0;i<10;i++){
            a[i]=r.nextInt(10);
        }
        System.out.println(Arrays.toString(a));
        Arrays.parallelSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a,200));
        int[] b=new int[10];
        Arrays.fill(b,10);
        int[] c=new int[10];
        Arrays.fill(c,10);
        System.out.println(Arrays.equals(b,c));
    }
}
