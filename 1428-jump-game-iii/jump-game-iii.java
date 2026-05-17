class Solution {
    public boolean canReach(int[] arr, int start) {
        int[] dp=new int[arr.length];

        boolean ans=f(arr,start,dp);
        return ans;
    }
    boolean f(int[] arr, int start,int[] dp){
        if(arr[start]==0){
            return true;
        }
        if(dp[start]==1){
            return false;
        }
        dp[start]=1;
        boolean take=false;
        if(start-arr[start]>=0){
            take=f(arr,start-arr[start],dp);
        }
        boolean take1=false;
        if(start+arr[start]<arr.length){
            take1=f(arr,start+arr[start],dp);
        }
        
        
        return take || take1;
    }
}