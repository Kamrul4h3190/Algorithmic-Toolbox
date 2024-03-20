import java.util.*;

public class Knapsack {
    /*static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }
        return result;
    }*/
    /*static int optimalWeight(int W, int[] w) {
        //write you code here
        Arrays.sort(w);
        int r = w.length,c =W+1 ;
        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                //first row with first weight
                if (i==0){
                    matrix[i][j] = w[i];
                } else if (j<w[i])
                {
                    matrix[i][j] = matrix[i-1][j];
                } else if (j>=w[i]) {
                    int max = Math.max(matrix[i-1][j],matrix[i-1][j-w[i]] + w[i] );
                    if (max<=W){
                        matrix[i][j] = max;
                    }
                }
            }
        }


        printWeightMatrix(matrix);
        return matrix[r-1][c-1];
    }*/
    static int optimalWeight(int W, int[] w) {
        //write you code here
        //Arrays.sort(w);
        int r = w.length, c = W + 1;
        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //first row,col
                if (i == 0) {
                    if (j < w[i]) {
                        matrix[i][j] = 0;
                    } else {
                        matrix[i][j] = w[i];
                    }
                } else if (j < w[i]) {
                    matrix[i][j] = matrix[i - 1][j];
                }

                else {
                   //if (j-w[i]>=0){
                       matrix[i][j] = Math.max( matrix[i-1][j],w[i]+ matrix[i-1][j-w[i]] );
                   //}

                }
            }
        }


        //printWeightMatrix(matrix);
        return matrix[r - 1][c - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }

    private static void printWeightMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

