class Solution {
    public boolean checkStrings(String s1, String s2) {
        Map<Character,Integer> even1=new HashMap<>();
        Map<Character,Integer> even2=new HashMap<>();
        Map<Character,Integer> odd1=new HashMap<>();
        Map<Character,Integer> odd2=new HashMap<>();

        int i = 0;
        while(i < s1.length()){
            if(i % 2 == 0){
                even1.put(s1.charAt(i), even1.getOrDefault(s1.charAt(i),0)+1);
                even2.put(s2.charAt(i), even2.getOrDefault(s2.charAt(i),0)+1);
            } else {
                odd1.put(s1.charAt(i), odd1.getOrDefault(s1.charAt(i),0)+1);
                odd2.put(s2.charAt(i), odd2.getOrDefault(s2.charAt(i),0)+1);
            }
            i++;
        }

        for(char ch : even1.keySet()){
            if(!even1.get(ch).equals(even2.getOrDefault(ch, 0))){
                return false;
            }
        }

        for(char ch : odd1.keySet()){
            if(!odd1.get(ch).equals(odd2.getOrDefault(ch, 0))){
                return false;
            }
        }

        return true;
    }
}