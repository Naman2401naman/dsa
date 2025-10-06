class Solution {
    public String simplifyPath(String path) {
        Stack<Character> stk=new Stack<>();
        if(path.length()>0){
            stk.push(path.charAt(0));
        }
        for(int i=1;i<path.length();i++){
            char ch=path.charAt(i);
            if(ch=='/'){
                if(stk.peek()=='/'){
                    continue;
                }else{
                    stk.push(ch);
                }
            }else if(ch=='.' && stk.peek()=='/'){
                if(i+1<path.length() && path.charAt(i+1)=='.' && (i+2==path.length() || path.charAt(i+2)=='/')){
                    if(stk.size()>1){
                        stk.pop();
                        while(!stk.isEmpty() && stk.peek()!='/' ){
                            stk.pop();
                        }
                    }
                    i++;
                }
                else if(i+1==path.length() ||path.charAt(i+1)=='/'){
                   continue;
                }else{
                    stk.push(ch);
                }
            }
            else{
                stk.push(ch);
            }
            
        }
       if(stk.size()>1 && stk.peek()=='/'){
            stk.pop();
       }
      StringBuilder str=new StringBuilder();
      for(int i=0;i<stk.size();i++){
        str.append(stk.get(i));
      }
      return str.toString();

    }
}