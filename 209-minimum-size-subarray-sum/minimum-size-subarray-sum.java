class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum=0;
        int r=0;

        for (int i = 0; i < n; i++) {
            sum+=nums[i];
            while(sum>=target){
                min=Math.min(min,i-r+1);
                sum-=nums[r++];
            }
        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
