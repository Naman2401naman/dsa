class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int left=0;
        int right=happiness.length-1;
        while(left<=right){
            int temp=happiness[left];
            happiness[left]=happiness[right];
            happiness[right]=temp;
            left++;
            right--;
        }
        long max=0;
        for(int i=0;i<k;i++){
            if(happiness[i]-i <0) break;
            max+=happiness[i]-i;
        }
        return max;
    }
}