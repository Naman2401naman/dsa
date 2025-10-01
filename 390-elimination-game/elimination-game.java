class Solution {
    public int lastRemaining(int n) {
        int head=1;
        int steps=1;
        boolean lefrig=true;
        while(n>1){
            if(lefrig || n%2==1){
                head+=steps;
            }
            n/=2;
            steps*=2;
            lefrig=!lefrig;
        }
        return head;
    }
}