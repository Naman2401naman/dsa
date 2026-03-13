class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        int i=1;
        int n=nums.length;
        for(int num:nums){
            maxPQ.add(num);
        }
        while(i<n){
            nums[i]=maxPQ.poll();
            i+=2;
        }
        i=0;
        while(i<n){
            nums[i]=maxPQ.poll();
            i+=2;
        }
    }
}