import java.util.*;
import java.io.*;

public class Partition3 {
    /*private static int partition3(int[] A,int k) {
        //write your code here
        int sum = 0,max =0;
        for (int n : A) {
            sum+=n;
            max = Math.max(max,n);
        }
        if (sum%k!=0 || max>sum/k) return 0;
        return helper(A,k,sum/k,0,new boolean[A.length],0);
    }
    private static int helper(int[] A,int k,int targetSum,int currSum,boolean[] visited,int index){
        if (k==0) return 1;
        if (currSum>targetSum) return 0;
        if (currSum==targetSum)
            helper(A,k-1,targetSum,0,visited,0);
        for (int i = index; i <A.length ; i++) {
            if (!visited[i]){
                visited[i] = true;
                if (helper(A,k,targetSum,currSum+A[i],visited,i+1)==1) return 1;
                visited[i] = false;
            }
        }
        return 0;
    }*/
    /*public  static boolean partition3(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        if(sum % k != 0 || maxNum > sum / k) return false;
        return helper(nums, k, sum / k, 0, new boolean[nums.length], 0);
    }

    private static boolean helper(int[] nums, int k, int targetSum,
                           int curSum, boolean[] visited, int innerStart){
        if(k == 0) return true;
        if(curSum > targetSum) return false;
        if(curSum == targetSum) return helper(nums, k - 1, targetSum, 0, visited, 0);

        for(int i = innerStart; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(helper(nums, k, targetSum, curSum + nums[i], visited, i + 1)) return true;
                visited[i] = false;
            }
        }
        return false;
    }*/

    public static int partition3(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        if(sum % k != 0 || maxNum > sum / k) return 0;
        return helper(nums, k, sum / k, 0, new boolean[nums.length], 0);
    }

    private static int helper(int[] nums, int k, int targetSum,
                              int curSum, boolean[] visited, int innerStart){
        if(k == 0) return 1;
        if(curSum > targetSum) return 0;
        if(curSum == targetSum) return helper(nums, k - 1, targetSum, 0, visited, 0);

        for(int i = innerStart; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(helper(nums, k, targetSum, curSum + nums[i], visited, i + 1)==1) return 1;
                visited[i] = false;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A,3));
    }
}

