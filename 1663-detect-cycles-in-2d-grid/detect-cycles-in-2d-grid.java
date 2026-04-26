class Solution {
    class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // each node is its own parent
        }
    }

    // Find parent
    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // path compression
    }

    // Union two nodes
    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pa] = pb;
        }
    }
}
    public boolean containsCycle(char[][] grid) {
         int n=grid.length;
         int m=grid[0].length;
         DSU dsu=new DSU(n*m);
        int[][] dir={{0,1},{1,0}};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int[] dirs:dir){
                    int m1=i+dirs[0];
                    int m2=j+dirs[1];
                    if(m1<n && m2<m && grid[i][j]==grid[m1][m2]){
                        int idx=i*m+j;
                        int idx2=m1*m+m2;
                        if(dsu.find(idx)==dsu.find(idx2)) return true;
                        dsu.union(idx,idx2);
                    }
                }
            }
        }
        return false;
    }
}