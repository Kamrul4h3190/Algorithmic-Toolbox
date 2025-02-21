import java.util.*;

public class LCM {
  /*private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }*/
  private static long lcm_fast(int a, int b) {
    int gcd = gcd_fast(a,b);
    return ((long) a *b)/gcd;
  }
  private static int gcd_fast(int a, int b) {
    int remainder = b%a;
    if(remainder == 0)return a;
    return gcd_fast(remainder,a);
  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_fast(a, b));
  }
}
