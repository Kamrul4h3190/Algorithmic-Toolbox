import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        /*if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here*/
        int element = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (count==0){
                element = a[i];
            }
            if (a[i]==element){
                count++;
                //System.out.println("e : "+element+",c+ : "+count);
            }else {
                count--;
                //System.out.println("e : "+element+",c- : "+count);
            }


        }
        if (count>0){
            int count2=0;
            int majorCount = a.length/2;
            for (int i = 0; i < a.length; i++) {
                if (a[i]==element){
                    count2++;
                    //System.out.println("c2 :"+count2);
                }
                if (count2>majorCount){
                    //System.out.println("element : "+element);
                    return element;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

