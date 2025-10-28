class Solution {
    public int countValidSelections(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long leftSum = 0;
        int totalScore = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                long rightSum = totalSum - leftSum;
                if (leftSum == rightSum) {
                    totalScore += 2;
                } else if (Math.abs(leftSum - rightSum) == 1) {
                                     totalScore += 1;
                }
            }
            leftSum += nums[i];
        }

        return totalScore;
    }
}