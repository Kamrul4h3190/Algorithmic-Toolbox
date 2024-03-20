import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        return getFibonacciHugeNaive(n,10);
    }
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long pisanoLength = pisanoPeriodLength(m);
        //System.out.println("for m = "+m+" pisano : "+pisanoLength);
        n= n%pisanoLength;
        //System.out.println("reduced n : "+n);
        long previous = 0;
        long current  = 1;
        long sum = 1;
        //finds n , reduced to pisano len
        for (int i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            //moduloing here because overflow may happen after 92 th fibonacci
            current = (tmp_previous + current)%m;
            sum+=current;
        }
        //System.out.println("reduced "+n+" th fib :"+current);
        //System.out.println("sum : "+sum);
        if (n==0){
            return 0;
        } else if (n==1) {
            return 1;
        }
        //System.out.println("reduced "+n+" th fib :"+current);
        //pisano reduced n%m
        return sum%10;
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

        //long m = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        //long s = getFibonacciHugeNaive(n,m);
        System.out.println(s);
    }
}

