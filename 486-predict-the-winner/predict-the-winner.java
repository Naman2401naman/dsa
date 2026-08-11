class Solution {

    public boolean predictTheWinner(int[] nums) {

        int difference = solve(nums, 0, nums.length - 1);

        return difference >= 0;
    }

    int solve(int[] nums, int left, int right) {

        // Only one number remains
        if (left == right) {
            return nums[left];
        }

        // Take left
        int takeLeft =
                nums[left] - solve(nums, left + 1, right);

        // Take right
        int takeRight =
                nums[right] - solve(nums, left, right - 1);

        // Current player chooses the better option
        return Math.max(takeLeft, takeRight);
    }
}