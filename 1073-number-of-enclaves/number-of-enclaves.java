class Solution {
    public int numEnclaves(int[][] grid) {
       int[] dr={-1,1,0,0};
       int[] dc={0,0,-1,1};
       int rows=grid.length;
       int cols=grid[0].length;
       int sum=0;
       Queue<int[]> queue=new LinkedList<>();
       for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    queue.offer(new int[]{r,c});
                    grid[r][c]=0;
                     int count = 1;
                    boolean flag = false;

                    // If starting cell is on boundary
                    if (r == 0 || r == rows - 1 ||
                        c == 0 || c == cols - 1) {
                        flag = true;
                    }
                    
                    while(!queue.isEmpty()){
                        int[] p=queue.poll();

                        int cr=p[0];
                        int cc=p[1];
                        for(int i=0;i<4;i++){
                            int nr=cr+dr[i];
                            int nc=cc+dc[i];
                            if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1){
                                if(nr==0 || nr==rows-1 || nc==0 || nc==cols-1){
                                    flag=true;
                                }
                                grid[nr][nc]=0;
                                queue.offer(new int[]{nr,nc});
                                count++;
                            }
                        }
                    }
                    if(flag==true){
                        count=0;
                    }
                    sum+=count;
                }
            }
       }
       return sum;
    }
}