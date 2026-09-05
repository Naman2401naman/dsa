class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] pefix=new int[n];
        int max=nums[0];
        int min=nums[n-1];
        for(int i=0;i<n;i++){
            if(max<nums[i]){
                max=nums[i];
            }
            pefix[i]=max;
        }
        int[] suf=new int[n];
        for(int i=n-1;i>=0;i--){
            if(min>nums[i]){
                min=nums[i];
            }
            suf[i]=min;
        }
        for(int i=0;i<n;i++){
            if(pefix[i]-suf[i]<=k){
                return i;
            }
        }
        return -1;
    }
}