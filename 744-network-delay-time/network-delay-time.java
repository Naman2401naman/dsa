class Solution {
    void addEdge(ArrayList<ArrayList<edge>> graph,int u,int v,int w){
        graph.get(u).add(new edge(v,w));
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<edge>> graph =
                new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            addEdge(graph,times[i][0],times[i][1],times[i][2]);
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<pair> pq=new PriorityQueue<>(
            (a,b)->a.distance-b.distance
        );
        dist[k]=0;
        pq.offer(new pair(k,0));
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int curr=p.node;
            int dist1=p.distance;
            if(dist1!=dist[curr]){
                continue;
            }
            for(edge e: graph.get(curr)){
                int nei=e.to;
                int wei=e.weight;
                if(dist1+wei<dist[nei]){
                    dist[nei]=dist1+wei;
                    pq.offer(new pair(nei,dist[nei]));
                }
            }
        }
        int max1=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max1=Math.max(max1,dist[i]);
        }

        return max1;
    }
    static class pair{
        int node;
        int distance;
        pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    static class edge{
        int to;
        int weight;
        edge(int to,int weight){
            this.to=to;
            this.weight=weight;
        }
    }
}