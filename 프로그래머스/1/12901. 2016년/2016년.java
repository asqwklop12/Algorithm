class Solution {
    String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};

    public String solution(int a, int b) {
        int totalDays = b; 
        for (int i = 0; i < a - 1; i++) {  
            totalDays += days[i];
        }
        
        int dayIndex = (totalDays + 4) % 7;
        return week[dayIndex];
    }
}
