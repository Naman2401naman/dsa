class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
       return recur(nums,target,0,sum);
    }
    int recur(int[] nums,int target,int idx,int sum){
        if(idx==nums.length){
            return sum==target?1:0;
        }
        int add=recur(nums,target,idx+1,sum+nums[idx]);
        int sub=recur(nums,target,idx+1,sum-nums[idx]);
        return add +sub;
    }
}
