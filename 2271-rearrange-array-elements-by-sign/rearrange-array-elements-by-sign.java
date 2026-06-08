class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=1;

        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                res[r]=nums[i];
                r=r+2;
            }else{
                res[l]=nums[i];
                l=l+2;
            }
        }
        return res;
    }
}