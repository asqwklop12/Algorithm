import java.util.*;

class Solution {
    int n;
    String result;
    public int solution(int n, int k) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        int temp = n;
        while(temp > 0) {
            sb.append(temp%k);
            temp /= k;
        }
        
        sb.reverse();
        this.result = sb.toString();
        this.n = sb.length();
        
         String[] parts = result.split("0");
        
        for(String str : parts) {
            if(str.isEmpty()) {
                continue;
            }
            long num = Long.parseLong(str);
            if(isPrime(num)) {
                answer++;
            }
        }
    
        return answer;
    }
    
    public boolean isPrime(long num) {
        if(num == 0 || num == 1) {
            return false;
        }

        for(int i = 2; i<=Math.sqrt(num);i++) {
            if(num % i == 0) {
                return false;
            }
            
        }
        
        return true;
        
    }
    
    
    
}
