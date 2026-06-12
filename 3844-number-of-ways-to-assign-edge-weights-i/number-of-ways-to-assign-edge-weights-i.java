class Solution {

    static final long MOD = 1_000_000_007L;
    int maxDepth = 0;
 
    private void dfs(int node, int parent, int depth,
                     ArrayList<Integer>[] adj) {

        maxDepth = Math.max(maxDepth, depth);

        for (int next : adj[node]) {
            if (next != parent) {
                dfs(next, node, depth + 1, adj);
            }
        }
    }

    private long power(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        if (n == 1) return 0;

        ArrayList<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1, -1, 0, adj);

        return (int) power(2, maxDepth - 1);
    }
}