class Solution {
     void addEdge(ArrayList<ArrayList<edge>> graph,int u,int v,double w){
        graph.get(u).add(new edge(v,w));
        graph.get(v).add(new edge(u,w));
    }

    static class pair{
        int node;
        double distance;
        pair(int node,double distance){
            this.node=node;
            this.distance=distance;
        }
    }

    static class edge{
        int to;
        double weight;
        edge(int to,double weight){
            this.to=to;
            this.weight=weight;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<edge>> graph =
                new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            addEdge(graph,edges[i][0],edges[i][1],succProb[i]);
        }
        PriorityQueue<pair> pq=new PriorityQueue<>(
            (a,b)->Double.compare(b.distance,a.distance)
        );
        double[] dist=new double[n];
        Arrays.fill(dist,Double.MIN_VALUE);
        dist[start_node]=1;
        pq.offer(new pair(start_node,1));
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int curr=p.node;
            double dist1=p.distance;
            if(dist1!=dist[curr]){
                continue;
            }
            for(edge e: graph.get(curr)){
                int nei=e.to;
                double wei=e.weight;
                if(dist1*wei>dist[nei]){
                    dist[nei]=wei*dist1;
                    pq.offer(new pair(nei,dist[nei]));
                }
            }
        }
        if(dist[end_node]==Double.MIN_VALUE){
            return 0;
        }
        return dist[end_node];
    }
}

