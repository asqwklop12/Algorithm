class Solution {
    boolean[] arr = new boolean[10];
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(int i : numbers) {
            arr[i] = true;
        }
        
        for(int i = 0 ; i< arr.length;i++) 
        {
            if(!arr[i]) {
                answer += i;
            }
            
        }
        
        
        return answer;
    }
}