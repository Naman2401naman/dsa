class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double []> pq=new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));
        for(int[] c: classes){
            double p=c[0];
            double t=c[1];
            double gain=((p+1)/(t+1))-(p/t);
            pq.offer(new double[]{gain,p,t});
        }
        while(extraStudents-->0){
            double[] a=pq.poll();
            double p1=a[1]+1;
            double t1=a[2]+1;
            double gain1=((p1 + 1) / (t1 + 1)) - (p1 / t1);
            pq.offer(new double[]{gain1,p1,t1});
        }
        double res=0;
        while(!pq.isEmpty()){
            double[] fin=pq.poll();
            res+=fin[1]/fin[2];
        }
        double ans=res/classes.length;
        return ans;
    }
}