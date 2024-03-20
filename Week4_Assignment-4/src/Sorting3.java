import java.io.*;
import java.util.*;
//final version submitted,passed
public class Sorting3 {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      //write your code here
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] < x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
       /* System.out.println("a : "+Arrays.toString(a));
        System.out.println("j : "+j);*/

        for (int i = j + 1; i <= r; i++) {
            if (a[i] == x) {
                j++;
                int t2 = a[i];
                a[i] = a[j];
                a[j] = t2;
            }
        }

       /* System.out.println("a : "+Arrays.toString(a));
        System.out.println("j : "+j);*/

      int m1 = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i]==a[j]){
                m1=i;
                break;
            }
        }
      int m2 = j;
        //System.out.println("m1,m2 : "+m1+","+m2);
      int[] m = {m1, m2};
      return m;
    }

    /*private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }*/
    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] < x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        System.out.println("a : "+Arrays.toString(a));
        System.out.println("j : "+j);

        for (int i = j + 1; i <= r; i++) {
            if (a[i] == x) {
                j++;
                int t2 = a[i];
                a[i] = a[j];
                a[j] = t2;
            }
        }
        /*int t3 = a[l];
        a[l] = a[j];
        a[j] = t3;*/

        System.out.println("a : "+Arrays.toString(a));
        System.out.println("j : "+j);

        int m1 = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i]==a[j]){
                m1=i;
                break;
            }
        }
        int m2 = j;
        System.out.println("m1,m2 : "+m1+","+m2);

        return j;
    }
    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r || l<0 || r>=a.length) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        //int k = 7;
        //System.out.println("p : "+k+", key : "+a[k]);
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        /*int m = partition2(a, l, r);
        randomizedQuickSort(a, l, m - 1);
        randomizedQuickSort(a, m + 1, r);*/
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        /*for (int k = 0; k < 300; k++) {
            randomizedQuickSort(a, 0, n - 1);
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }*/
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

