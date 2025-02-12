import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i =0;i<commands.length;i++) {
            int x = commands[i][0];
            int y = commands[i][1];
            int z = commands[i][2];
            int[] newArray = Arrays.copyOfRange(array,x-1,y);
            answer[i] = sort(newArray,z);
        }
        
        return answer;
    }
    
    public int sort(int[] array,int index) {
        Arrays.sort(array);
        return array[index-1];
    }
}