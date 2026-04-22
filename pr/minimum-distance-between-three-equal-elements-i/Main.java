class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        int ans = Integer.MAX_VALUE;

        for(int i = 0;i<n;i++) {

            for(int j = 0; j<n;j++) {
                if(i == j) continue;

                for(int k = 0; k<n;k++) {
                    if(i == k) continue;
                    if(j == k) continue;

                    if(nums[i] == nums[j] && nums[i] == nums[k] && nums[j] == nums[k]) {
                        int result = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                        ans = Math.min(ans,result);
                    }

                }

            }
        }
        

        if(ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}
