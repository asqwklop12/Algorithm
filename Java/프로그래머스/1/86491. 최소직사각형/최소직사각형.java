import java.util.*;

class Node {
  public int x;
  public int y; 
  
  Node(int x,int y) {
      this.x = x;
      this.y = y;
  }
    
    
}

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        List<Node> nodes = new ArrayList<>();
        
        for(int i = 0 ; i<sizes.length;i++) {
           int x = sizes[i][0];
           int y = sizes[i][1];
           nodes.add(change(x,y));
        }
        
        int[] xarr = new int[sizes.length];
        int[] yarr = new int[sizes.length];
        
        for(int i = 0 ; i< nodes.size();i++) {
            Node node = nodes.get(i);
            xarr[i] = node.x;
            yarr[i] = node.y;
            
        }
        
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i<nodes.size();i++) {
            maxX = Math.max(maxX,xarr[i]);
            maxY = Math.max(maxY,yarr[i]);
        }
        
        
        return maxX*maxY;
    }
    
    public Node change(int x,int y) {
        if(x < y) {
            return new Node(y,x);
        }
        
        return new Node(x,y);
    }
}