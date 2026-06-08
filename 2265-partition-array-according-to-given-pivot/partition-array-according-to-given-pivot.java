class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> result=new ArrayList<>();
        List<Integer> left=new ArrayList<>();
        List<Integer> middle=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                left.add(nums[i]);
            }else if(nums[i]==pivot){
                middle.add(nums[i]);
            }else{
                right.add(nums[i]);
            }
        }
        result.addAll(left);
        result.addAll(middle);
        result.addAll(right);
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=result.get(i);
        }
        return arr;
    }
}