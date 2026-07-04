class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        int min=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int minutes=0;
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};

        while(!queue.isEmpty()){
            int size=queue.size();
            boolean tr=false;
            for(int i=0;i<size;i++){
                int[] cur=queue.poll();
                int nx=cur[0];
                int ny=cur[1];
                for(int[] d:dir){
                    int rn=nx+d[0];
                    int rm=ny+d[1];
                    if(rn>=0 && rm>=0 && rn<rows && rm<cols &&
                    grid[rn][rm]==1){
                        grid[rn][rm]=2;
                        fresh--;
                        tr=true;
                        queue.offer(new int[]{rn,rm});
                    }
                }
            }
            if(tr){
                min++;
            }
        }
        return fresh==0 ?min:-1;
    }
}