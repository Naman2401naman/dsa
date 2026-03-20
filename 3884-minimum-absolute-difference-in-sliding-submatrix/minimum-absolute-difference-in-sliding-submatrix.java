class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n=grid.length-k+1;
        int m=grid[0].length-k+1;
        int[][] result=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                List<Integer> a=new ArrayList<>();
                for(int x=i;x<i+k;x++){
                    for(int y=j;y<j+k;y++){
                        a.add(grid[x][y]);
                    }
                }
                Collections.sort(a);
                int min=Integer.MAX_VALUE;
                int prev=a.get(0);
                for(int l=1;l<a.size();l++){
                    if(a.get(l)!=prev){
                        min=Math.min(min,Math.abs(a.get(l)-prev));
                    }
                    prev=a.get(l);
                }
                result[i][j] = (min == Integer.MAX_VALUE) ? 0 : min;
            }
        }
        return result;
    }
}