class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freq=new int[26];
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)-97>=0){
                freq[word.charAt(i)-97]++;
            }
        }
        int count =0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='A' && word.charAt(i)<='Z'){
                if((freq[word.charAt(i)-65])!=0){
                    count++;
                    freq[word.charAt(i)-65]=0;
                }
            }
        }
        return count;
    }
}