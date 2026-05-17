class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int l=s.length();
        boolean[] dp=new boolean[l];
        dp[0]=true;
        if(s.charAt(l-1)=='1'){
            return false;
        }
        int reachable=0;
        for(int i=1;i<l;i++){
            if((i-minJump)>=0 && dp[i-minJump]){
                reachable++;
            }
            if((i-maxJump-1)>=0 && dp[i-maxJump-1]){
                reachable--;
            }

            if(s.charAt(i)=='0' && reachable>0){
                dp[i]=true;
            }
        }
        return dp[l-1];
    }
}