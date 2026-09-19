class Solution {
    HashMap<Long,Integer> mp=new HashMap<>();
    public int integerReplacement(int n) {
        return solve((long)n);
    }
    int solve(long n){
        if(n==1){
            return 0;
        }
        if(mp.containsKey(n)){
            return mp.get(n);
        }
        int ans;
        if(n%2==0){
            ans=solve(n/2)+1;
        }else{
            ans=1+Math.min(solve(n-1),solve(n+1));
        }
        mp.put(n,ans);
        return ans;
    }
}