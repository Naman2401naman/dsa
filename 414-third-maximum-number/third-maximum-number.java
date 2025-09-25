class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            s.add(nums[i]);
        }
        List<Integer> list=new ArrayList<>(s);
        Collections.sort(list);
        int size=list.size();
        if(list.size()<3){
            return list.get(size-1);
        }
        return list.get(size-3);
    }
}