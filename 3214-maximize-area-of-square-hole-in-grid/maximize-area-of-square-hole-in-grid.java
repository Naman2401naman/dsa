class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int max1=1;
        int con1=1;
        for(int i=1;i<hBars.length;i++){
            if((hBars[i-1]+1)==hBars[i]){
                con1++;
                
            }else{
                con1=1;
            }
            max1=Math.max(max1,con1);
        }
        int max2=1;
        int con2=1;
        for(int i=1;i<vBars.length;i++){
            if((vBars[i-1]+1)==vBars[i]){
                con2++;
                
            }else{
                
                con2=1;
            }
            max2=Math.max(max2,con2);
        }
        int x=Math.min(max1+1,max2+1);
        return x*x;
    }
}