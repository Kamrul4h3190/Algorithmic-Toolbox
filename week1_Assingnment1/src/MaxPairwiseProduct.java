import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long maxPairwiseProductNaive(int[] numbers){
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                        (long) numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }
    static long maxPairwiseProductFast(int[] numbers) {
        int index1 = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[index1])
                index1 = i;
        }
        int index2;
        if (index1==0){
            index2 =1;
        }else{
            index2 = 0;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (i != index1 && numbers[i] > numbers[index2])
                index2 = i;
        }
        return (long) numbers[index1] *numbers[index2];
    }

    public static void stressTest(int size,int maxRange){
        //stress test
        while (true){
            int n = new Random().nextInt(2,size);
            int[] numbers = new int[n];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = new Random().nextInt(maxRange);
            }
            for (int number : numbers) {
                System.out.print(number+" ");
            }

            long res1 = maxPairwiseProductNaive(numbers);
            long res2 = maxPairwiseProductFast(numbers);
            if (res1==res2){
                System.out.println(",OK : "+res1+" , "+res2);
            }else {
                System.out.println(",Wrong answer : "+res1+" , "+res2);
                return;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //manual input
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        //file auto input
        /*FastScanner scanner = new FastScanner(new FileInputStream("src\\dataset.txt"));
        int[] numbers = new int[200000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }*/
        System.out.println(maxPairwiseProductFast(numbers));
        //stressTest(5,9);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
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
