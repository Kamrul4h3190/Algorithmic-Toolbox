import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int r = a.length+1 , c = b.length+1;
        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i==0){
                    matrix[i][j] = 0;
                } else if (j == 0) {
                    matrix[i][j] = 0;
                } else if (a[i-1] == b[j-1] ) {
                    matrix[i][j] = matrix[i-1][j-1]+1;
                }else {
                    matrix[i][j] =  Math.max(matrix[i-1][j],matrix[i][j-1])  ;
                }
            }
        }

        //printChangeMatrix(matrix);
        return matrix[r-1][c-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
    private static void printChangeMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }
}

