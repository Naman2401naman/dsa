class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<String> s1=new ArrayList<>();
        if(k>s.length()){
            return "";
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            int count =0;

            for(int j=i;j<s.length();j++){
                if(s.charAt(j)=='1'){
                    count++;
                }
                if(count ==k){
                    s1.add(s.substring(i,j+1));
                    min=Math.min(min,j+1-i);
                    break;
                }
            }
        }
        List<String> s2=new ArrayList<>();
        for(String c:s1){
            if(c.length()==min){
                s2.add(c);
            }
        }
        Collections.sort(s2);
        if(s2.isEmpty()){
            return "";
        }
        return s2.get(0);
    }
}