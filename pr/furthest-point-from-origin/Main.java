class Solution {
    int ans = Integer.MAX_VALUE;

    char[] arr;
    int n;
    
    public int furthestDistanceFromOrigin(String moves) {
        this.arr = moves.toCharArray();
        this.n = moves.length();
        int pos = 0;
        int blank = 0;
        for(int i = 0 ; i<n;i++) {
            if(arr[i] == 'L') {
                pos--;
            }
            if(arr[i] == 'R') {
                pos++;
            }
            if(arr[i] == '_') {
                blank++;
            }
        }

        return Math.abs(pos) + blank;
    }

    
}
