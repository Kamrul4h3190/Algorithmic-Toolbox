import java.util.Scanner;


public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0.0000;
        //write your code here
        while (capacity!=0){
            //pick max density item
            int itemIndex = 0;
            double itemDensity = Double.MIN_VALUE;
            for (int i = 0; i < values.length; i++) {
                if ((double) values[i] /weights[i] > itemDensity){
                    itemDensity = (double) values[i] /weights[i];
                    itemIndex = i;
                }
            }
            //whole taken
            if (weights[itemIndex]<=capacity){
                value = value + values[itemIndex];
                capacity = capacity - weights[itemIndex];
                //System.out.println("whole added value : "+values[itemIndex]);
                //System.out.println("remaining capacity : "+capacity);
                values[itemIndex]=0;//to do not compare this item in next iteration
            }//partial taken
            else if (weights[itemIndex]>capacity) {
                value = value + capacity*itemDensity;
                capacity = capacity -( weights[itemIndex]-( weights[itemIndex]-capacity ) );
                //System.out.println("partial added value : "+values[itemIndex]);
                //System.out.println("remaining capacity : "+capacity);
                values[itemIndex]=0;//to do not compare this item in next iteration
            }
        //System.out.println("Max dense item value : "+values[itemIndex]);
        }
        //return value;
        double var = Math.round(value*10000)/10000.0000;
        return var;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
