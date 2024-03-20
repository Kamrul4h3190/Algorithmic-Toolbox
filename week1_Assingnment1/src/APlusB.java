import java.util.Scanner;

class APlusB {
    static int sumOfTwoDigits(int digit1, int digit2) {
        return digit1 + digit2;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(sumOfTwoDigits(a, b));
    }
}