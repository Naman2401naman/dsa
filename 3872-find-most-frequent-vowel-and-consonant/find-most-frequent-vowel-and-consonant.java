class Solution {
    public int maxFreqSum(String s) {
        String s1="";
        String s2="";
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='a'|| ch=='o'||ch=='e'||ch=='i'||ch=='u'){
                s1+=ch;
            }else{
                s2+=ch;
            }
        }
        int vowels=freq(s1);
        int conso=freq(s2);
        return vowels+conso;
    }
    int freq(String str){
        if(str.length()==0){
            return 0;
        }
        char[] arr = str.toCharArray();
        Arrays.sort(arr); // sort characters

        int maxFreq = 1, currFreq = 1;
        char maxChar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                currFreq++;
            } else {
                currFreq = 1;
            }

            if (currFreq > maxFreq) {
                maxFreq = currFreq;
                maxChar = arr[i];
            }
        }
        return maxFreq;
    }
}