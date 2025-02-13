class Solution {
  public int[] solution(int n, int m) {
      int[] answer = {(n < m)?result(n,m):result(m,n),(n < m)?result1(n,m):result1(m,n)};
      return answer;
  }
    
  public int result(int a,int b) {
     
      if (b == 0) {
          return a;
      } 
      
          return result(b,a%b);
  }
   public int result1(int a,int b) {
     
        return b/result(a,b)  * a/result(a,b) * result(a,b);
  }  
    
}