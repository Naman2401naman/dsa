class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            List<Integer> temp=new ArrayList<>();
            while(n>0){
                int o=n%10;
                n=n/10;
                temp.add(o);
            }
            Collections.reverse(temp);
            ans.addAll(temp);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}