import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            int ab=0;
            int ba=0;
            for (int j = i+1; j < a.length; j++) {
                ab = Integer.parseInt(a[i]+a[j]);
                ba = Integer.parseInt(a[j]+a[i]);
                if (ba > ab){
                    String temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }

        for (String s : a) {
            result.append(s);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

