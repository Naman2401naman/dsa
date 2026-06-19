class Solution {
    public int largestAltitude(int[] gain) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<gain.length;i++){
            
            max=Math.max(max,sum);
            sum+=gain[i];
        }
        max=Math.max(max,sum);
        return max;
    }
}