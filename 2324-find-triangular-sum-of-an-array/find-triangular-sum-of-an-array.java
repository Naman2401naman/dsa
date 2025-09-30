class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length-1;
        while(n!=0){
            for(int i=0;i<n;i++){
                nums[i]=(nums[i]+nums[i+1])%10;
            }
            n--;
        }
        return nums[0];
    }
}