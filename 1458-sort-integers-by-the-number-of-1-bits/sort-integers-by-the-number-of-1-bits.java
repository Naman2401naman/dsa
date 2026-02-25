class Solution {
    public int[] sortByBits(int[] arr) {
        int[] sorted=Arrays.stream(arr).
                    boxed().
                    sorted(Comparator.comparingInt(Integer::bitCount).thenComparingInt(a->a)).mapToInt(Integer::intValue).toArray();
                    return sorted;
    }


    
}