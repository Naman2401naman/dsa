class Solution {
    public int minCost(String colors, int[] neededTime) {
        int timeSum=0;
        for(int i=0;i<colors.length()-1;i++){
            char ch=colors.charAt(i);
            if(ch==colors.charAt(i+1)){
                if(neededTime[i]>neededTime[i+1]){
        
                    int temp=neededTime[i];
                    neededTime[i]=neededTime[i+1];
                    neededTime[i+1]=temp;
                     timeSum+=neededTime[i];
                }else{
                    timeSum+=neededTime[i];
                }
            }
            
        }
        return timeSum;
    }
}