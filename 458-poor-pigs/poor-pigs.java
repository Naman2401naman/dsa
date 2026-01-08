class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int T=minutesToTest/minutesToDie;
        int i=0;
        while(Math.pow(T+1,i)<buckets){
            i++;
        }
        return i;
    }
}