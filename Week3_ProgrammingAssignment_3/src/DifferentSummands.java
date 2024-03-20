import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int s = 0;
        do {
            if (n==s)
                return summands;
            if (n-s < 0){
                int required = Math.abs(n);
                summands.remove(summands.size()-1);
                int last = summands.remove(summands.size()-1);
                summands.add(last+required);
                return summands;
            }else {
                n=n-s;
                s++;
                summands.add(s);
            }
        }while (true);
        //return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

