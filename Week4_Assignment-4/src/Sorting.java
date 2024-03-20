import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    /*private static int[] partition3(int[] a, int l, int r) {
        //write your code here
        //if (l<0 || r>=a.length || l>=r) return new int[]{};
        //if (l<0 || r>=a.length) return new int[]{};
        //if (l<0 ) l++;if (r>=a.length) r--;
        int p = random.nextInt(r - l + 1) + l;
        //int p = 3;

        for (; ; ) {
            boolean foundLeft = false;
            boolean foundRight = false;
            int leftBigIndex = p;
            int rightSmallIndex = p;

            for (int i = p - 1; i >= l; i--) {
                if (a[i] > a[leftBigIndex]) {
                    leftBigIndex = i;
                    foundLeft = true;
                    break;
                }
            }

            for (int i = p + 1; i <= r; i++) {
                if (a[i] <= a[rightSmallIndex]) {
                    rightSmallIndex = i;
                    foundRight = true;
                    break;
                }
            }
            //break
            if (!foundLeft && !foundRight) {
                //System.out.println("terminated both side ok");
                break;
            }

            if (foundLeft && foundRight) {
                swap(a, leftBigIndex, rightSmallIndex);
            } else if (foundLeft) {
                swap(a, leftBigIndex, p);
                p = leftBigIndex;
            } else {
                swap(a, p, rightSmallIndex);
                p = rightSmallIndex;
            }
        }

        int m1 = p;
        for (int i = m1; i >= l; i--) {
            if (a[i] != a[m1]){
                m1 = i;
                break;
            }
        }
        int m2 = p;
        //System.out.println("p : "+p+", key : "+a[p]+", m1 : "+m1+", m2 : "+m2);
        //System.out.println(" a: "+ Arrays.toString(a));
        return new int[]{m1, m2};
    }*/
    private static int[] partition3(int[] a, int l, int r) {
        //write your code here
        //if (l<0 || r>=a.length || l>=r) return new int[]{};
        //if (l<0 || r>=a.length) return new int[]{};
        //if (l<0 ) l++;if (r>=a.length) r--;
        int p = random.nextInt(r - l + 1) + l;
        //int p = 3;

        for (; ; ) {
            boolean foundLeft = false;
            boolean foundRight = false;
            int leftBigIndex = p;
            int rightSmallIndex = p;

            for (int i = p - 1; i >= l; i--) {
                if (a[i] > a[leftBigIndex]) {
                    leftBigIndex = i;
                    foundLeft = true;
                    break;
                }
            }

            for (int i = p + 1; i <= r; i++) {
                if (a[i] <= a[rightSmallIndex]) {
                    rightSmallIndex = i;
                    foundRight = true;
                    break;
                }
            }
            //break
            if (!foundLeft && !foundRight) {
                //System.out.println("terminated both side ok");
                break;
            }

            if (foundLeft && foundRight) {
                swap(a, leftBigIndex, rightSmallIndex);
            } else if (foundLeft) {
                swap(a, leftBigIndex, p);
                p = leftBigIndex;
            } else {
                swap(a, p, rightSmallIndex);
                p = rightSmallIndex;
            }
        }

        int m1 = p;
        for (int i = m1; i >= l; i--) {
            if (a[i] != a[m1]){
                m1 = i;
                break;
            }
        }
        int m2 = p;
        //System.out.println("p : "+p+", key : "+a[p]+", m1 : "+m1+", m2 : "+m2);
        //System.out.println(" a: "+ Arrays.toString(a));

        return new int[]{m1, m2};
    }
    /*private static int partition3(int[] a, int l, int r) {
        int p = random.nextInt(r - l + 1) + l;
        //int p = 4;

        for (; ; ) {
            boolean foundLeft = false;
            boolean foundRight = false;
            int leftBigIndex = p;
            int rightSmallIndex = p;

            for (int i = p-1; i >=l ; i--) {
                if (a[i] > a[leftBigIndex]){
                    leftBigIndex=i;
                    foundLeft = true;
                    break;
                }
            }
            for (int i = p+1; i <= r ; i++) {
                if (a[i] <= a[rightSmallIndex]){
                    rightSmallIndex=i;
                    foundRight = true;
                    break;
                }
            }
            //break
            if (!foundLeft && !foundRight){
                //System.out.println("terminated both side null");
                break;
            }
            if (foundLeft && foundRight){
                swap(a,leftBigIndex,rightSmallIndex);
            } else if (foundLeft) {
                swap(a,leftBigIndex,p);
                p = leftBigIndex;
            } else {
                swap(a,p,rightSmallIndex);
                p=rightSmallIndex;
            }
        }


        //System.out.println("p index : "+p+", p element : "+a[p]);
        return p;
    }*/
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

        int p = random.nextInt(r - l + 1) + l;
        //int p = 4;
        //System.out.println("P : "+p);
        for (; ; ) {
            boolean foundLeft = false;
            boolean foundRight = false;
            int leftBigIndex = p;
            int rightSmallIndex = p;

            for (int i = p - 1; i >= l; i--) {
                if (a[i] > a[leftBigIndex]) {
                    leftBigIndex = i;
                    foundLeft = true;
                    break;
                }
            }

            for (int i = p + 1; i <= r; i++) {
                if (a[i] <= a[rightSmallIndex]) {
                    rightSmallIndex = i;
                    foundRight = true;
                    break;
                }
            }
            //break
            if (!foundLeft && !foundRight) {
                //System.out.println("terminated both side null");
                break;
            }

            if (foundLeft && foundRight) {
                swap(a, leftBigIndex, rightSmallIndex);
            } else if (foundLeft) {
                swap(a, leftBigIndex, p);
                p = leftBigIndex;
            } else {
                swap(a, p, rightSmallIndex);
                p = rightSmallIndex;
            }
        }

        System.out.println("a: "+ Arrays.toString(a));
        System.out.println(" p index: "+p+", n element : "+a[p]+", left : "+l+", right : "+r);
        return p;
    }

    private static void swap(int[] a, int left, int right) {
        int t = a[left];
        a[left] = a[right];
        a[right] = t;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        //use partition3
        /*int m = partition2(a, l, r);
        randomizedQuickSort(a, l, m - 1);
        randomizedQuickSort(a, m + 1, r);*/

        int[] m = partition3(a, l, r);
        if (m[0]!=m[1]){
            randomizedQuickSort(a, l, m[0]);
            if (m[1]+1 <= r)
                randomizedQuickSort(a, m[1]+1, r);
        }


    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        //int n = scanner.nextInt();
        //int[] a = new int[n];

        //int n = 16;
        //int[] a = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};

        int n = 9;
        int[] a = {8 ,2 ,2 ,4 ,2 ,4 ,2 ,5, 5};

        /*int n = 9;
        int[] a = {9 ,2 ,8 ,2 ,2 ,4 ,2 ,2 ,4};*/

        //int n = 10;
        //int[] a ={512766168 ,717383758 ,5 ,126144732 ,5 ,573799007 ,5 ,5 ,5 ,405079772};
        /*for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }*/
        for (int k = 0; k < 20; k++) {
            System.out.print("iteration : "+(k+1)+" - ");
            randomizedQuickSort(a, 0, n - 1);

            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        /*randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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

