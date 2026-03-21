class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        Stack<Integer> st=new Stack<>();
        for(int i=x;i<k+x;i++){
            for(int j=y;j<y+k;j++){
                st.add(grid[i][j]);
            }
        }
        for(int i=x;i<k+x;i++){
            for(int j=k-1+y;j>=y;j--){
                grid[i][j]=st.pop();
            }
    }
        return grid;
    }
}