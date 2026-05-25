class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right=0;
        int left=numbers.length-1;
        int n=numbers.length;
        int[] arr=new int[2];
        while(right<left){
            if(numbers[left]+numbers[right]==target){
                arr[0]=right+1;
                arr[1]=left+1;
                break;
            }else if(numbers[left]+numbers[right]<target){
                right++;
            }else{
                left--;
            }
        }
        return arr;
    }
}