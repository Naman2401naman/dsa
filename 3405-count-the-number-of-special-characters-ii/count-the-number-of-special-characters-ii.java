class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastOcurrence=new int[27];
        int[] firstOcurrence=new int[27];
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z'){
                lastOcurrence[ch-97+1]=i+1;
            }
        }
        for(int j=0;j<word.length();j++){
            char ch=word.charAt(j);
            if(ch>='A' && ch<='Z'){
                if(firstOcurrence[ch-65+1]==0){
                    firstOcurrence[ch-65+1]=j+1;
                }
            }
        }
        int count=0;
        for(int i=1;i<27;i++){
            if(lastOcurrence[i]<firstOcurrence[i] && lastOcurrence[i]!=0 && firstOcurrence[i]!=0){
                count++;
            }
        }
        return count;
    }
}