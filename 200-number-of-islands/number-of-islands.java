class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        Set<String> st=new HashSet<>();
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1' && !st.contains(i+","+j)){
                    count++;
                    bfs(grid,i,j,st,dir,rows,cols);
                }
            }
        }
        return count;
    }
    void bfs(char[][] grid,int r,int c,Set<String> vis,int[][] dir,int rows,int cols){
        Queue<int[]> q=new LinkedList<>();
        vis.add(r+","+c);
        q.offer(new int[]{r,c});
        while(!q.isEmpty()){
            int[] pt=q.poll();
            int rw=pt[0];
            int cl=pt[1];

            for(int[] direction:dir){
                int nr=rw+direction[0];
                int nc=cl+direction[1];
                if(nr>=0 && nc>=0 && 
                nr<rows && nc<cols && grid[nr][nc]=='1' && !vis.contains(nr+","+nc)){
                    vis.add(nr+","+nc);
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}