import java.util.*;

public class FibonacciSumSquares {


    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long pisanoLength = pisanoPeriodLength(10);
        //System.out.println("for from = "+from+" pisano : "+pisanoLength); // for 10 pisano len : 60
        n = n % pisanoLength;
        //System.out.println("from reduced pisano : "+from);
        //System.out.println("to reduced pisano : "+to);

        //System.out.println("to increased by pisano : "+to);
        long previous = -1;
        long current = 1;
        long fib = 0;

        long prevFib = 0;
        for (int i = 0; i <= n; i++) {
            //fib = previous + current;
            fib = (previous + current)%10;
            previous = current;
            current = fib;
            //System.out.println("fib : "+fib);
            if (i == n-1) {
                //sum= (sum+fib)%10;
                prevFib= fib;
                //System.out.println("prevFib : "+prevFib);
            }
        }
        //System.out.println("fib : "+fib);
        //return sum;
        long res = (fib*(fib+prevFib));
        //System.out.println("res : "+res);
        return res%10;
    }
    public static long pisanoPeriodLength(long m)
    {
        long prev = 0;
        long curr = 1;
        long res = 0;

        for(int i = 0; i < m * m; i++)
        {
            long temp = 0;
            temp = curr;
            curr = (prev + curr) % m;
            prev = temp;

            if (prev == 0 && curr == 1)
                return i + 1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

