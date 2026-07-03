class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        boolean[] bol=new boolean[n];
        boolean d=dfs(list,source,destination,bol);
        return d;

    }
    boolean dfs(List<List<Integer>> list,int source,int destination,boolean[] bol){
        if(source==destination){
            return true;
        }
        bol[source]=true;
        for(int ad:list.get(source)){
            if(!bol[ad]){
                if(dfs(list,ad,destination,bol)){
                    return true;
                }
            }
        }
        return false;
    }
}