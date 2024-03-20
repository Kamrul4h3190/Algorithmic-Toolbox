import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] prices, int[] clicks) {
        //write your code here
        long result = 0;

        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int maxClick = Integer.MIN_VALUE;
            int maxPrice = Integer.MIN_VALUE;
            int currMaxClickIndex=0;
            int currMaxPriceIndex=0;
            for (int j = 0; j < n; j++) {
                if (clicks[j]>maxClick){
                    maxClick = clicks[j];
                    currMaxClickIndex = j;
                }
                if (prices[j]>maxPrice){
                    maxPrice = prices[j];
                    currMaxPriceIndex=j;
                }
            }
            //System.out.println("max click,price : "+maxClick+","+maxPrice);
            result = result + (long) maxClick *maxPrice;
            clicks[currMaxClickIndex] = 0;
            prices[currMaxPriceIndex] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

