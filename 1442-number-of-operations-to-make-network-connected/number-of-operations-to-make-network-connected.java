class Solution {
     ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();

    int find(int x) {
        if (parent.get(x) == x)
            return x;

        int root = find(parent.get(x));
        parent.set(x, root); // path compression
        return root;
    }

    void union(int x, int y) {

        int px = find(x);
        int py = find(y);

        if (rank.get(px) > rank.get(py)) {
            parent.set(py, px);
        } 
        else if (rank.get(px) < rank.get(py)) {
            parent.set(px, py);
        } 
        else {
            parent.set(px, py);
            rank.set(py, rank.get(py) + 1);
        }
    }
    public int makeConnected(int n, int[][] connections) {

        
        int extra=0;
       
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
        }
        for(int i=0;i<connections.length;i++){
            int s=find(connections[i][0]);
            int y=find(connections[i][1]);
            if(s==y){
                extra++;
            }else{
                    union(s,y);
            }

        }
        int space=0;
        for(int i=0;i<n;i++){
            if(find(i)==i){
                space++;
            }
        }
        int need = space - 1;

        if (extra < need) return -1;

        return need;
       
    }
}