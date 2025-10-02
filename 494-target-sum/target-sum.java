class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        // If impossible
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;

        int P = (sum + target) / 2;  // subset sum target

        int[] dp = new int[P + 1];
        dp[0] = 1; // one way to make sum 0 (take nothing)

        for (int num : nums) {
            for (int s = P; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }

        return dp[P];
    }
}
