class Solution {
    public int[] sumZero(int n) {
        int[] arr= new int[n];        
        int count=0;
        if(n%2==0){
            for(int i=1;i<=n/2;i++){
                arr[count]=i;
                count++;
            }
            for(int j=1;j<=n/2;j++){
                arr[count]=(-1)*j;
                count++;
            }
        }else{
            for(int i=0;i<=n/2;i++){
                arr[count]=i;
                count++;
            }
            for(int j=1;j<=n/2;j++){
                arr[count]=(-1)*j;
                count++;
            }
        }
        
        return arr;
    }
}