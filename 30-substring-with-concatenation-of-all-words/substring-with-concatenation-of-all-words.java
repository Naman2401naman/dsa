class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int wordLen = words[0].length();
        int numWords = words.length; 
        int windowLen = wordLen * numWords;
        Map<String ,Integer> map=new HashMap<>();
        for(String st:words){
            map.put(st,map.getOrDefault(st,0)+1);
        }

        for(int i=0;i<wordLen;i++){
            Map<String,Integer> sot=new HashMap<>();
            int left=i;
            int found=0;
            for(int j=i;j<=s.length()-wordLen;j+=wordLen){
                String currentWord = s.substring(j, j + wordLen);
                if(map.containsKey(currentWord)){
                    sot.put(currentWord,sot.getOrDefault(currentWord,0)+1);
                    found++;
                
                    while(sot.get(currentWord)>map.get(currentWord)){
                    String leftWord = s.substring(left,left + wordLen);
                    sot.put(leftWord,sot.get(leftWord)-1);
                    found--;
                    left+=wordLen;
                    }

                    if(found==numWords){
                        result.add(left);
                        String leftWord = s.substring(left,left+wordLen);
                    sot.put(leftWord,sot.get(leftWord)-1);
                    found--;
                    left+=wordLen;
                    }
                }else{
                    sot.clear();
                    found=0;
                    left=j+wordLen;
                }
            }
        }
       return result;
    }
}