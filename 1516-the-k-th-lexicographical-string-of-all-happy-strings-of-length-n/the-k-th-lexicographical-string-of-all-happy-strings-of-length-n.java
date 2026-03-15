class Solution {
    List<String> ans1=new ArrayList<>();
    public String getHappyString(int n, int k) {
        char[] ch={'a','b','c'};
        String ans="";
        solve(ans,n,ch);
        if(ans1.size()<k){
            return "";
        }else{
            return ans1.get(k-1);
        }
    }
    void solve(String s,int n,char[] ch){
        if(s.length()==n){
            ans1.add(s);
            return;
        }
        for(char c:ch){
            if(s.isEmpty() || s.charAt(s.length()-1)!=c){
                solve(s+c,n,ch);
            }
        }
    }
}