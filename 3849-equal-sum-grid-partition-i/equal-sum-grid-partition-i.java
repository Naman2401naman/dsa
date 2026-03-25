class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long[] r=new long[grid.length];
        long[] c=new long[grid[0].length];
        for(int i=0;i<grid.length;i++){
            long sum=0;
            for(int j=0;j<grid[0].length;j++){
                sum+=grid[i][j];
            }
            r[i]=sum;
        }
        for(int i=0;i<grid[0].length;i++){
            long sum=0;
            for(int j=0;j<grid.length;j++){
                sum+=grid[j][i];
            }
            c[i]=sum;
        }
        long total=0;
        for(int i=0;i<grid.length;i++){
            total+=r[i];
        }
        long rtotal=0;
        for(int i=0;i<grid.length;i++){
            rtotal+=r[i];
            if(rtotal*2 == total){
                return true;
            }
        }
        long ctotal=0;
        for(int i=0;i<grid[0].length;i++){
            ctotal+=c[i];
            if(ctotal*2 == total){
                return true;
            }
        }
        return false;
    }
}