class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        // Build prefix sum
        long[] pref = new long[n];
        pref[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }

        long result = Long.MIN_VALUE;

        // Loop for each modulo group (start positions)
        for (int start = 0; start < k; start++) {
            long currSum = 0;
            int i = start;

            // Iterate by jumps of size k
            while (i < n && i + k - 1 < n) {

                int j = i + k - 1;  // end index of chunk

                // sum of nums[i..j]
                long subSum = pref[j] - (i > 0 ? pref[i - 1] : 0);

                // extend or restart
                currSum = Math.max(subSum, currSum + subSum);

                // update answer
                result = Math.max(result, currSum);

                i += k; // move to next block of size k
            }
        }

        return result;
    }
}
