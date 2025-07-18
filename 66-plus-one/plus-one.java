class Solution {
    public int[] plusOne(int[] digits) {

        int n=digits.length;
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            else{
                digits[i]=0;  //incase if digit is greater than 9
                              //then carry 1 will get to the next digit
            }
            
        }
        int[]result=new int[n+1];
        result[0]=1;  //incase if all the digits are 9
        return result;
        
    }
}