import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int[] coins = {10,5,1};

        int totalCoins=0;
        for (int coin : coins) {
            int numOfCurrentCoin  = m/coin;
            if (numOfCurrentCoin>=1){
                //System.out.println(coin+" taken "+numOfCurrentCoin+" times.");
                totalCoins+=numOfCurrentCoin;
                //System.out.println("totalCoins : "+totalCoins);
                m = m - coin*numOfCurrentCoin;
                //System.out.println("currAmount : "+m);
            }
        }

        return totalCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

