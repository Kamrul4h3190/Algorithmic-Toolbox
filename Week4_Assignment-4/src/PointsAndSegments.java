import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        if (starts.length<2){
            for (int i = 0; i < points.length; i++) {
                if (points[i] >= starts[0] && points[i] <= ends[0]){
                    cnt[i] = 1;
                }
            }
            return cnt;
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (points[i] >= starts[j] && points[i] <= ends[j]){
                    cnt[i]++;
                } else if (starts[j]>points[i]) {
                    break;
                }
            }
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (points[i] >= starts[j] && points[i] <= ends[j]) {
                    System.out.println("segment : " + starts[j] + " ," + ends[j]);
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        randomizedQuickSort(starts, ends, 0, n - 1);
        //printSegments(starts, ends, n);
        //use fastCountSegments
        //int[] cnt = naiveCountSegments(starts, ends, points);
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }

    }

    private static Random random = new Random();

    private static int[] partition3(int[] a, int[] b, int l, int r) {
        //write your code here
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] < x) {
                j++;
                swap(a, i, j);
                swap(b, i, j);
            }
        }

        swap(a, l, j);
        swap(b, l, j);

        for (int i = j + 1; i <= r; i++) {
            if (a[i] == x) {
                j++;
                swap(a, i, j);
                swap(b, i, j);
            }
        }

        int m1 = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == a[j]) {
                m1 = i;
                break;
            }
        }
        int m2 = j;
        int[] m = {m1, m2};
        return m;
    }

    private static void swap(int[] a, int index1, int index2) {
        int t2 = a[index1];
        a[index1] = a[index2];
        a[index2] = t2;
    }

    private static void randomizedQuickSort(int[] a, int[] b, int l, int r) {
        if (l >= r || l < 0 || r >= a.length) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;

        swap(a, l, k);
        swap(b, l, k);
        int[] m = partition3(a, b, l, r);
        randomizedQuickSort(a, b, l, m[0] - 1);
        randomizedQuickSort(a, b, m[1] + 1, r);
    }

    public static void printSegments(int[] starts, int[] ends, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(starts[i] + " " + ends[i]);
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

