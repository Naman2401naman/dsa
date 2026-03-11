class Solution {
    public int bitwiseComplement(int n) {
        int bit=Integer.toBinaryString(n).length();
        int mask=(1<<bit)-1;
        return n^mask;
    }
}