class Solution {
    public int[] maxValue(int[] nums) {
        int[] pref=new int[nums.length];
        int[] suf=new int[nums.length];
        int[] ans=new int[nums.length];
        pref[0]=nums[0];
        suf[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            pref[i]=Math.max(nums[i],pref[i-1]);
        }
        for(int j=nums.length-2;j>=0;j--){
            suf[j]=Math.min(nums[j],suf[j+1]);
        }
        ans[nums.length-1]=pref[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(pref[i]<=suf[i+1]){
                ans[i]=pref[i];
            }else{
                ans[i]=ans[i+1];
            }
        }
        return ans;
    }
}