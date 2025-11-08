class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n = nums.length;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int max=0;
        for(int key:map.keySet()){
            if(map.get(key) > n/3){
                result.add(key);
            }
        }
        return result;
    }
}