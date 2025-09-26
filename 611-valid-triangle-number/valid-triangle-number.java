class Solution {
    public int triangleNumber(int[] nums) {
        removeZeroes(nums);
        Arrays.sort(nums);
        if(nums.length<3){
            return 0;
        }
        int sum=0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                   if(nums[i]+nums[j]>nums[k]){
                    sum++;
                   }
                }
            }
        }
        return sum;
    }
    public static int[] removeZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                list.add(num);
            }
        }
        // convert List<Integer> back to int[]
        return list.stream().mapToInt(i -> i).toArray();
    }
}