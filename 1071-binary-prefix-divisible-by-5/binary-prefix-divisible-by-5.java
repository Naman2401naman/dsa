class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans=new ArrayList<>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=(2*sum+nums[i])%5;
            if(sum%5==0){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}