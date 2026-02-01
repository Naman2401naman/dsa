class Solution {
    public int minimumCost(int[] nums) {
        int sum=nums[0];
        Arrays.sort(nums,1,nums.length);
        sum+=nums[1]+nums[2];
        return sum;
    }
}