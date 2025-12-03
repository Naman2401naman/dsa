class Solution {
    public int[][] merge(int[][] intervals) {
        for(int i=0;i<intervals.length-1;i++){
            for(int j=i+1;j<intervals.length;j++){
                if(intervals[i][0]>intervals[j][0]){
                    int[] temp=intervals[i];
                    intervals[i]=intervals[j];
                    intervals[j]=temp;
                }
            }
        }
        int[][] temp=new int[intervals.length][2];
        temp[0]=intervals[0];
        int index=0;
        for(int i=1;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(start<=temp[index][1]){
                temp[index][1]=Math.max(end,temp[index][1]);
            }else{
                index++;
                temp[index]=intervals[i];
            }
        }
        int[][] result=new int[index+1][2];
        for(int i=0;i<=index;i++){
            result[i]=temp[i];
        }
        return result;
    }
}