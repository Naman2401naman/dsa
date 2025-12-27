class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)-> a[0]-b[0]);
        int[] count=new int[n];
        long[] timer=new long[n];
        int idx=0;
        while(idx<meetings.length){
            int[] time=meetings[idx];
            int start=time[0];
            int end=time[1];
            int room=-1;
            long min=Long.MAX_VALUE;
            int earli=-1;
            int dur=end-start;
            for(int i=0;i<n;i++){
                if(timer[i]<min){
                    min=timer[i];
                    earli=i;
                }
                if(timer[i]<=start){
                    room=i;
                    break;
                }
            }
            if(room!=-1){
                timer[room]=end;
                count[room]++;
            }
            else{
                timer[earli]+=dur;
                count[earli]++;
            }
            idx++;
        }
        int max=0,idr=0;
        for(int i=0;i<n;i++){
            if(count[i]>max){
                max=count[i];
                idr=i;
            }
        }
        return idr;
    }
}