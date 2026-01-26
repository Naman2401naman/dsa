class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] bask=new boolean[baskets.length];
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<baskets.length;j++){
                if(fruits[i]<=baskets[j] && bask[j]==false){
                    bask[j]=true;
                    break;
                }
            }
        }
        int count=0;
        for(int i=0;i<baskets.length;i++){
            if(bask[i]==false){
                count++;
            }
        }
        return count;
    }
}