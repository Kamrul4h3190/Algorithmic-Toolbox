import java.util.*;

public class FibonacciPartialSum {

    private static long getFibonacciPartialSumNaive(long from, long to) {
        return getFibonacciHugeNaive(from, to);
    }

    private static long getFibonacciHugeNaive(long from, long to) {
        if (from <= 1 && to <= 1)
            return to;

        long pisanoLength = pisanoPeriodLength(10);
        //System.out.println("for from = "+from+" pisano : "+pisanoLength); // for 10 pisano len : 60
        from = from % pisanoLength;
        //System.out.println("from reduced pisano : "+from);
        to = to % pisanoLength;
        //System.out.println("to reduced pisano : "+to);

        if (to<from){
            to+= pisanoLength;
        }
        //System.out.println("to increased by pisano : "+to);
        long previous = -1;
        long current = 1;
        long fib = 0;

        long sum = 0;
        for (int i = 0; i <= to; i++) {
            fib = previous + current;
            previous = current;
            current = fib;
            //System.out.println("fib : "+fib);
            if (i >= from) {
                sum= (sum+fib)%10;
                //System.out.println("sum : "+sum);
            }
        }
        return sum;
    }

    public static long pisanoPeriodLength(long m) {
        long prev = 0;
        long curr = 1;
        long res = 0;

        for (int i = 0; i < m * m; i++) {
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
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

