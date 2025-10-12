import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        int[] point = new int[3];
        for(int i = 0; i< answers.length;i++) {
            if (answers[i] ==student1[i%(student1.length)]) {
                point[0]++;
            }
            
            if (answers[i] == student2[i%(student2.length)]) {
                point[1]++;
            }
            
            if (answers[i] == student3[i%(student3.length)]) {
                point[2]++;
            }
        }
        
        int win = point[0];    
        for(int i = 1;i< point.length;i++) {
            if (win < point[i]) {
                win = point[i];
            }
            
        }
        
        List<Integer> winstack = new ArrayList<>();
        for(int i = 0; i<point.length;i++) {
            if (win == point[i]) {
                winstack.add(i);   
            }
        }
        
        int[] answer = new int [winstack.size()];
        
        for(int i = 0; i <winstack.size();i++) {
            answer[i] = winstack.get(i) + 1;
        }
        
        return answer;
    }
}