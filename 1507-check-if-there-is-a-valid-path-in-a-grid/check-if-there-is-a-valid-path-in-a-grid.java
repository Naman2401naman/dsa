class Solution {
    int[] parent;

    int find(int n){
        if(parent[n]!=n){
            parent[n]=find(parent[n]);
        }
        return parent[n];
    }
    void union(int a,int b){
        int pa=find(a);
        int pb=find(b);
        if(pa!=pb){
            parent[pa]=pb;
        }
    }
    public boolean hasValidPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        parent =new int[m*n];
        for(int i=0;i<n*m;i++){
            parent[i]=i;
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] typeDirs = {
            {},
            {2,3}, 
            {0,1}, 
            {2,1}, 
            {3,1}, 
            {2,0}, 
            {3,0} 
        };
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int gr=grid[i][j];
                for(int d:typeDirs[gr]){
                    int i1=i+dirs[d][0];
                    int i2=j+dirs[d][1];
                    if(i1<0|| i2<0 || i1>=n || i2>=m){
                        continue;
                    }
                    if(d==1){
                        if(grid[i1][i2]==2 || grid[i1][i2]==5 || grid[i1][i2]==6){
                            union(i * m + j, i1 * m + i2);
                        }
                    }else if(d==3){
                         if(grid[i1][i2]==1 || grid[i1][i2]==3 || grid[i1][i2]==5){
                             union(i * m + j, i1 * m + i2);
                        }
                    }else if(d==0){
                        if(grid[i1][i2]==2 || grid[i1][i2]==3 || grid[i1][i2]==4){
                             union(i * m + j, i1 * m + i2);
                        }
                    }else if(d==2){
                         if(grid[i1][i2]==1 || grid[i1][i2]==6 || grid[i1][i2]==4){
                             union(i * m + j, i1 * m + i2);
                        }
                    }
                }
            }
        }
        return find(0)==find(m*n-1);
    }
}