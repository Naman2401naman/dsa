class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        reverseArray(capacity);
        int sum=0;
        for(int i=0;i<apple.length;i++){
            sum+=apple[i];
        }
        int idx=0;
        for(int j=0;j<capacity.length;j++){
            if(sum>0){
                sum-=capacity[j];
                idx++;
            }else{
                break;
            }
        }
        return idx;
    }
     public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move pointers inward
            start++;
            end--;
        }
    }
}