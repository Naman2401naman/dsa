class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        while(numBottles>=numExchange){
            int new1 =numBottles/numExchange;
            int gain=numBottles%numExchange;
            sum+=new1;
            numBottles=gain+new1;
        }
        return sum;
    }
}