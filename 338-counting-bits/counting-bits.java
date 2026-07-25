class Solution {
    public int[] countBits(int n) {
        int cnt=0;
        int ans=1;
        while(ans<n){
            ans*=2;
            cnt++;
        }
        int[] dp=new int[n+1];
        int s=1;
        int j=0;
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=dp[i%s]+1;
            if(i%s==0){
                s=(int)Math.pow(2,j);
                j++;
            }
        }
        return dp;
    }
}