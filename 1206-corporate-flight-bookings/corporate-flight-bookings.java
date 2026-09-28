class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans=new int[n];
        int[] diff=new int[n+1];
        for(int i=0;i<bookings.length;i++){
            diff[bookings[i][0]-1]+=bookings[i][2];
            diff[bookings[i][1]]-=bookings[i][2];
        }
        int curr=0;
        ans[0]=diff[0];
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]+diff[i];
        }
        return ans;
    }
}