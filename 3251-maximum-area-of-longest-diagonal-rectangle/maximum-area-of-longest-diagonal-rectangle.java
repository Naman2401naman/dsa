class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxarea=0;
        int maxval=0;
        for(int i=0;i<dimensions.length;i++){
                int length=dimensions[i][0];
                int width=dimensions[i][1];
                int currenval=length*length + width*width;
                if(currenval>maxval || currenval==maxval && length*width> maxarea){
                    maxarea =length*width;
                    maxval=currenval;
                }
            
        }
        return maxarea;
    }
}