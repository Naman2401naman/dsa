class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n=mat.length;
        int n1=mat[0].length;
        int[][] res=new int[n][n1];
        for(int i=0;i<n;i++){
            srt(mat,i,0,res);
        }
        for(int j=1;j<n1;j++){
            srt(mat,0,j,res);
        }
        return res;
    }
    void srt(int[][] mat,int row,int col,int[][] res){
        int rows=mat.length;
        int cols=mat[0].length;
        int len=Math.min(rows-row,cols-col);
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=mat[row+i][col+i];
        }
        Arrays.sort(arr);
        for(int i=0;i<len;i++){
            res[row+i][col+i]=arr[i];
        }

    }
}