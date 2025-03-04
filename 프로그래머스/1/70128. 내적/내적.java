class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int size = a.length;
        for(int i = 0 ; i < size; i++) {
            answer += (a[i] * b[i]);
        }
        return answer;
    }
}