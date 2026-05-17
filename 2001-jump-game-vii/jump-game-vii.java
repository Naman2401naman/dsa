class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp=new boolean[s.length()];
        if(s.charAt(s.length()-1)!='0'){
            return false;
        }
        dp[s.length()-1]=true;
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)=='1'){
                dp[i]=false;
            }else{
                if((i+minJump)>s.length()-1){
                    dp[i]=false;
                }else{
                    for(int j=i+minJump;j<=Math.min(i+maxJump,s.length()-1);j++){
                        if(dp[j]==true){
                            dp[i]=true;
                            break;
                        }
                    }
                }
            }

        }
        return dp[0];
    }
}