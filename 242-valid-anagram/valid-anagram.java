class Solution {
    public boolean isAnagram(String s, String t) {
        char[] c=s.toCharArray();
        char[] ch=t.toCharArray();
        Arrays.sort(c);
        Arrays.sort(ch);
        String s1=new String(c);
        String s2=new String(ch);
        if(s1.equals(s2)){
            return true;

        }
        return false;
    }
}