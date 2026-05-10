class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        
        // initialize all as unreachable
        for(int i = 0; i < n; i++) dp[i] = -1;
        
        dp[n - 1] = 0; // last index needs 0 jumps
        
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if(Math.abs(nums[j] - nums[i]) <= target && dp[j] != -1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[0];
    }
}