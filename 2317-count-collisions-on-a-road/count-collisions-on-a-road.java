class Solution {
    public int countCollisions(String directions) {
        int i=0;
        while(i<directions.length() && directions.charAt(i)=='L') i++;

        int j=directions.length()-1;
        while(j>=0 && directions.charAt(j)=='R') j--;

        int count=0;
        for(int k=i;k<=j;k++){
            if(directions.charAt(k)!='S'){
                count++;
            }
        }
    return count;
    }
}