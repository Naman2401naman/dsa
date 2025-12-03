class Solution {
    public int missingNumber(int[] nums) {
        int nlen=nums.length;
        int res=nlen;
        for(int i=0;i<nlen;i++){
            res^=i^nums[i];
        }
        return res;
    }
}