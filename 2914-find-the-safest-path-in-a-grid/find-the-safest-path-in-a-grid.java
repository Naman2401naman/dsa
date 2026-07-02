class Solution {
    int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] pair;
        Queue<int[]> queue=new LinkedList<>();
        
        
        int n=grid.size();
        int m=grid.get(0).size();
        int[][] dist=new int[n][m];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid.get(i).get(j)==1){
                   queue.add(new int[]{i,j});
                   dist[i][j]=0;
                }
            }
        }
        
        
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int ind=curr[0];
            int indx=curr[1];
            for(int[] dir:directions){
                int nx=ind+dir[0];
                int ny=indx+dir[1];
                if(nx>=0 && ny>=0 && nx<n && ny<m && dist[nx][ny]==-1){
                    dist[nx][ny]=dist[ind][indx]+1;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
       

        // If start or end has a thief
        if (dist[0][0] == 0 || dist[n - 1][n - 1] == 0)
            return 0;

        int low = 0;
        int high = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                high = Math.max(high, dist[i][j]);
            }
        }
        int ans =0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(dist,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    boolean check(int[][] dist,int limit){
        int n=dist.length;
        if(dist[0][0]<limit) return false;

        boolean[][] visited=new boolean[n][n];
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0]=true;
        while(!queue.isEmpty()){
            int[] r=queue.poll();
            int idx=r[0];
            int idxn=r[1];
            if(idx==n-1 && idxn==n-1 ){
                return true;
            }
            for(int[] dir:directions){
                int nx=dir[0]+idx;
                int ny=dir[1]+idxn;
                if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && dist[nx][ny]>=limit){
                    visited[nx][ny]=true;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        return false;
    }
}