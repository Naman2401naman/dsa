class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp=new HashMap<>();
        for(String s: strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String ss=new String(c);
            if(!mp.containsKey(ss)){
                mp.put(ss,new ArrayList<>());
            }
            mp.get(ss).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}