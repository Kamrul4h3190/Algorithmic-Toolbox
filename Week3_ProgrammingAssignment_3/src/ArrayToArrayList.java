// Java program to illustrate conversion
// of an array to an ArrayList

import java.util.Collections;
import java.util.ArrayList;

class ArrayToArrayList {
    public static void func3(String arr[])
    {
        ArrayList<String> array_list = new ArrayList<String>();

        // Using Collections.addAll() method
        //Collections.addAll(array_list, arr);
        Collections.addAll(array_list,arr);
        System.out.print(array_list);
    }

    public static void main(String[] args)
    {

        String array[] = { "ABC", "DEF", "GHI", "JKL" };
        func3(array);
    }
}
