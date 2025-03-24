class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;

        // 원래 : price
        // 처음 가지고 있는 금액
        // count
        long result = 0;
        for(int i = 1; i<=count;i++) {
            result += (long)price * i;
        }

        answer = result - money;
        
        if(answer <= 0) {
            return 0;
        }
        
        return answer;
    }
}