class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int n=nums.length;
        int even =0;
        int odd=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                int left=(i>0)?nums[i-1]:Integer.MAX_VALUE;
                int right=(i+1<n)?nums[i+1]:Integer.MAX_VALUE;
                if(nums[i]>=Math.min(left,right)){
                    even+=nums[i]-Math.min(left,right)+1;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i%2==1){
                int left=(i>0)?nums[i-1]:Integer.MAX_VALUE;
                int right=(i+1<n)?nums[i+1]:Integer.MAX_VALUE;
                if(nums[i]>=Math.min(left,right)){
                    odd+=nums[i]-Math.min(left,right)+1;
                }
            }
        }
    return Math.min(even,odd);
    }
}