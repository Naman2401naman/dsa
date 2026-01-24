class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int maxSum=0;
        while(i<j){
            maxSum=Math.max(nums[i]+nums[j],maxSum);
            i++;
            j--;
        }
        return maxSum;
    }
}