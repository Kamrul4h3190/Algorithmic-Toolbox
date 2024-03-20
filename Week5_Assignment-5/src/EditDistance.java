import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
    int r = s.length()+1 , c = t.length()+1;
    int[][] matrix = new int[r][c];

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (i==0){
            matrix[i][j] = j;
        } else if (j == 0) {
            matrix[i][j] = i;
        } else if (s.charAt(i-1) == t.charAt(j-1) ) {
           matrix[i][j] = matrix[i-1][j-1];
        }else {
           matrix[i][j] = Math.min( Math.min(matrix[i-1][j],matrix[i][j-1]),matrix[i-1][j-1] )+1 ;
        }
      }
    }

    //printChangeMatrix(matrix);
    return matrix[r-1][c-1];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
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
