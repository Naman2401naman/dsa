class Solution {
    public double angleClock(int hour, int minutes) {
        double angle=0;
        if(hour==12){
            hour=0;
        }
        angle =Math.abs((30*hour)-(5.5*minutes));
        double angle2 =360-angle;
        if(angle2<angle){
            return angle2;
        }
        return angle;
    }
}