class Solution {
    public int numOfWays(int n) {
        int mod=1000000007;
        long sum=6;
        long diff=6;
        for(int i=2;i<=n;i++){
            long nsum=(3*sum+2*diff)%mod;
            long ndiff=(2*sum+2*diff)%mod;
            sum=nsum;
            diff=ndiff;
        }
        return (int)(sum+diff)%mod;
    }
}