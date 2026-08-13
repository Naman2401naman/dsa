class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length){
            return -1;
        }
        int low=1;
        int high=(int) 1e9;
        while(low<high){
            int mid=low+(high-low)/2;
            if(isPoss(bloomDay,m,k,mid)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    boolean isPoss(int[] bloom,int m,int k,int day){
        int total=0;
        for(int i=0;i<bloom.length;i++){
            int count=0;
            while(i<bloom.length && count<k && bloom[i]<=day){
                count++;
                i++;
            }
            if(count==k){
                total++;
                i--;
            }
            if(total>=m){
                return true;
            }
        }
        return false;
    }
}