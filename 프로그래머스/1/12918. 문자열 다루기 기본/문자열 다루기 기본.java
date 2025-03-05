class Solution {
    public boolean solution(String s) {
        boolean answer = false;
       try {
        if(s.length() == 4 || s.length() == 6) {
               Long.parseLong(s);
            return true;
        }
        } catch(Exception e) {
            return false;
        }
        return answer;
    }
}