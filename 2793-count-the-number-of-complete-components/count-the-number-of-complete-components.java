class Solution {

    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {

                List<Integer> component = new ArrayList<>();

                dfs(i, adj, vis, component);

                int vertices = component.size();
                int degreeSum = 0;

                for (int node : component) {
                    degreeSum += adj.get(node).size();
                }

                if (degreeSum == vertices * (vertices - 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    void dfs(int node,
             List<List<Integer>> adj,
             boolean[] vis,
             List<Integer> component) {

        vis[node] = true;
        component.add(node);

        for (int next : adj.get(node)) {

            if (!vis[next]) {
                dfs(next, adj, vis, component);
            }
        }
    }
}