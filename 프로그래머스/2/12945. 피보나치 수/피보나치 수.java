import java.util.*;
class Solution {
    int[] dp;
    public int solution(int n) {
        int answer = 0;
        dp = new int[n + 1];  // 배열 크기 설정
        Arrays.fill(dp, -1);
        
        dp[0] = 0;
        dp[1] = 1;
        
        return dpaction(n);
    }
    
    public int dpaction(int n) {
        if(n == 0) {
            return dp[0];
        }
        
        if(n == 1) {
            return dp[1];
        }
        
        if(dp[n] != -1) {
            return dp[n] % 1234567;
        }
     
        dp[n] = dpaction(n-1) + dpaction(n-2);
            
        return dp[n] % 1234567;
    }
}