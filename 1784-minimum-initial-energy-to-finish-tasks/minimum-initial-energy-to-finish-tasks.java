class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int ans =0;
        int r=0;
        for(int [] b:tasks){
            if(r<=b[1]){
                ans+=b[1]-r;
            }
            r=Math.max(b[1]-b[0],r-b[0]);
        }
        return ans;
    }
}