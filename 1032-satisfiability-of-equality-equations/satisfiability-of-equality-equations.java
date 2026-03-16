class Solution {
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();

    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<26;i++){

            parent.add(i);
            rank.add(0);
        }
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1)=='='){
                union(equations[i].charAt(0)-'a',equations[i].charAt(3)-'a');
            }
        }
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1)=='!'){
                if(find(equations[i].charAt(0)-'a')==find(equations[i].charAt(3)-'a')){
                    return false;
                }
            }
        }
        return true;
    }
    int find(int i){
        if(i==parent.get(i)){
            return i;
        }
        int root =find(parent.get(i));
        parent.set(i,root);
        return root;
    }
    void union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(rank.get(px)>rank.get(py)){
            parent.set(py,px);
        }else if(rank.get(px)<rank.get(py)){
            parent.set(px,py);
        }else{
            parent.set(py,px);
            rank.set(py,rank.get(py)+1);
        }
    }
}