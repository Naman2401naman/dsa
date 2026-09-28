class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> mp=new HashMap<>();
        for(List<String> s2:knowledge){
            mp.put(s2.get(0),s2.get(1));
        }
        StringBuilder ans=new StringBuilder();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                int j=i+1;
                while(s.charAt(j)!=')'){
                    j++;
                }
                String s1=s.substring(i+1,j);
                ans.append(mp.getOrDefault(s1,"?"));
                i=j+1;
            }else{
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
}