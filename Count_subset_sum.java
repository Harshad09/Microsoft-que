
// Find the total count of subsets whose sum is 10

import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        int[] arr = new int[]{2,3,5,6,8,10};
        int sum = 10;
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        
        Arrays.fill(dp[0],0);
        for(int i=0;i<n+1;i++) {
            dp[i][0] = 1;
        }
        
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<sum+1;j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][sum]);
     }
}
// Answer is 3
// arr[] = [2,3,5,6,8,10]
// {2,3,5}, {2,8}, {10}
// There are 3 subsets whose sum is 10.
