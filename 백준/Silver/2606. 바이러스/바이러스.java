
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static LinkedList<Integer>[] connList;
    public static boolean[] visited;
    
    public static int cnt = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int nodeCnt = Integer.parseInt(br.readLine());
        int lineCnt = Integer.parseInt(br.readLine());
        
        connList = new LinkedList[nodeCnt+1];
        visited = new boolean[nodeCnt+1];
        
        for(int i=0; i <= nodeCnt; i++) {
            connList[i] = new LinkedList<Integer>();
        }
        
        for(int i=0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            
            connList[num1].add(num2);
            connList[num2].add(num1);
        }
        
        System.out.println(BFS());
        
    }
 
    public static int BFS() {
        int cnt = -1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        while(!queue.isEmpty()) {
            int num = queue.poll();
            
            // 방문 여부
            if(visited[num]) continue;
            visited[num] = true;
            
            cnt += 1;
            
            for(int n : connList[num]) {
                queue.offer(n);
            }
        }
        
        return cnt;
    }
}
