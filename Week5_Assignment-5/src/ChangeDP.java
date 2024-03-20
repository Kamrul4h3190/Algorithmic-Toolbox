import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here//coins : 1,5,6,8
        //int[] coins = {1,5,6,8};
        int[] coins = {1,3,4};
        int[][] matrix = new int[coins.length][m+1];

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (i==0)//first row with 1 cents.
                    {
                    matrix[i][j] = j;
                } else if (j<coins[i]) {
                    matrix[i][j] = matrix[i-1][j];
                } else if (j>= coins[i]) {
                    int currCoinVal = coins[i];
                    matrix[i][j] = Math.min( matrix[i-1][j],matrix[i][j-currCoinVal]+1 );
                }
            }
        }

        printChangeMatrix(matrix);

        return matrix[coins.length-1][m];
    }
    private static void printChangeMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

