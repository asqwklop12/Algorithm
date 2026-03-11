class Solution {
    int[] buy;
    int total;
    int[][] cost;
    int[][] hint;
    int answer;
    public int solution(int[][] cost, int[][] hint) {
        answer = Integer.MAX_VALUE;
        this.cost = cost;
        this.hint = hint;
        total = cost.length;
        buy = new int[total];
        dfs(0,0);
        return answer;
    }
    
    public void dfs(int stage,int price) {
        if(stage == total) {
            answer = Math.min(answer,price);
            return;
        }
        
        int hitBuy = Math.min(buy[stage], total - 1);
        
         dfs(stage+1, price + cost[stage][hitBuy]);
        
        if(stage < total  -1) {
        int[] c = hint[stage];
        // 힌트권을
        // 구매하는 경우 
        int cc = price + cost[stage][hitBuy] + c[0];
        
        for(int i = 1; i<c.length;i++) {
            buy[c[i]-1]++;
        }
        
        dfs(stage+1, cc);
        cc -= c[0];
        
        for(int i = 1; i<c.length;i++) {
            buy[c[i]-1]--;
        }
            
        }
        
       
    }
}
