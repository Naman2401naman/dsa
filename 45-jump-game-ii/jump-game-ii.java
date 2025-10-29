class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        if(n==1){
            return 0;
        }
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int maxjump=nums[i];
            int minJmps=Integer.MAX_VALUE;

            for(int j=1;j<=maxjump && i+j<n;j++){
                int landingIndex=i+j;
                if(dp[landingIndex]!=Integer.MAX_VALUE){
                    minJmps =Math.min(minJmps,dp[landingIndex]);
                }
            }
            if(minJmps!=Integer.MAX_VALUE){
               dp[i]=1+minJmps;
            }
        }
        return dp[0];
    }
}