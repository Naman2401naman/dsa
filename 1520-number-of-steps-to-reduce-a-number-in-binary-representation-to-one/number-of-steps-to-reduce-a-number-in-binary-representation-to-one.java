class Solution {
    public int numSteps(String s) {
        int step=0;
        int c=0;
        for(int i=s.length()-1;i>0;i--){
            int bit=c+(s.charAt(i)-'0');

            if(bit==1){
                step+=2;
                c=1;
            }else{
                step+=1;
            }

        }
        return step+c;
    }
}