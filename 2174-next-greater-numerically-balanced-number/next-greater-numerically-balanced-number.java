class Solution {
    public int nextBeautifulNumber(int n) {
        int n1 =  n+1;
        while(!Beautiful(n1)){
            n1++;
        }
        return n1;
    }
    boolean Beautiful(int n){
        int[] arr=new int[10];

        while(n>0){
            int i=n%10;
            n=n/10;
            arr[i]++;
        }
        for(int i=0;i<10;i++){
            if(arr[i]!=0 && arr[i]!=i){
                return false;
            }
        }
        return true;
    }
}