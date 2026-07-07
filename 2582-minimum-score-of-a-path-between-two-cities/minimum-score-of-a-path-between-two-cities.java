class Solution {
    public int minScore(int n, int[][] roads) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        int ans=Integer.MAX_VALUE;
        boolean[] bol=new boolean[n+1];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(1);
        bol[1]=true;
        while(!queue.isEmpty()){
            int q=queue.poll();
            for(Pair next:adj.get(q)){
                ans=Math.min(ans,next.wt);
                if(!bol[next.v]){
                    bol[next.v]=true;
                    queue.offer(next.v);
                }
            }
        }
       return ans; 
    }
    class Pair{
        int v;
        int wt;
        Pair(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
    }
}