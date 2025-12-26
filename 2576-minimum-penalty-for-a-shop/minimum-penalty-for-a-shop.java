class Solution {
    public int bestClosingTime(String customers) {
        int max=0;
        int idx=0;
        int dekh=0;
        for(int i=0;i<customers.length();i++){
            if(customers.charAt(i)=='N'){
                dekh--;
            }else{
                dekh++;
            }

            if(dekh>max){
                max=dekh;
                idx=i+1;
            }
        }
        return idx;
    }
}