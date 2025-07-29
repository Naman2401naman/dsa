class Solution {
    public double findMaxAverage(int[] nums, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        double max=0;
        int index=0;
        double sum=0;
        while(index<nums.length && index<k){
            sum+=list.get(index);
            index++;
        }
        max=sum/k;
        for(int i=1;i<nums.length-k+1;i++){
            int prevval=list.get(i-1);
            int next=list.get(i+k-1);
            sum=(sum-prevval+next);
            double sum1=sum/k;
            max=Math.max(sum1,max);
        }
        return max;
    }
}