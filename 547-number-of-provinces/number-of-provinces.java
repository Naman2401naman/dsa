class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,isConnected,visited);
                count++;
            }
        }
        return count;
    }
    void dfs(int i1,int[][] isConnected,boolean[] visited){
        visited[i1]=true;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i] && isConnected[i1][i]==1){
                dfs(i,isConnected,visited);
            }
        }
    }
}