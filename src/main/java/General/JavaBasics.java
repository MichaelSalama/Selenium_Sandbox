package General;

import java.util.ArrayList;
import java.util.*;
import java.util.List;


public class JavaBasics
{
    public static void main(String[] args)
    {
        //memory allocated
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 5;
        arr[3] = 7;
        arr[4] = 8;

        int[] arr2 = {1, 2, 5, 7, 8};

        System.out.println(arr2[2]);
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] % 2 == 0) System.out.println(arr2[i]);
        }

        String[] name = {"One", "Two", "Three"};

        for (String s : name) {
            System.out.println(s);
        }

        ArrayList<String> a = new ArrayList<>();
        a.add("One");
        a.add("two");
        a.add("7amada");

        System.out.println(a.get(1));

        //convert array to arraylist
        List<String> nameArrayList = Arrays.asList(name);


        //two ways to declare a string
        String s ="blah";
        String s1 = new String ("Blah");
    }
}
