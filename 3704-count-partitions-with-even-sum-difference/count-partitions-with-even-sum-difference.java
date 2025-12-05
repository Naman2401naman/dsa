class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        int count = 0;

        for (int s : nums) {
            sum += s;
        }

        int se = 0;
        for (int j =0;j<nums.length-1;j++) {
            se += nums[j];
            int ans = sum - se;

            if ((sum - 2 * se) % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
