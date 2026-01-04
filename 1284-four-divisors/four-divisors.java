class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += divisi(nums[i]);
        }
        return sum;
    }

    int divisi(int num) {
        int sums = 1 + num;   // 1 and num are divisors
        int count = 2;        // already counted 1 and num

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                int d = num / i;

                if (i == d) {        // perfect square
                    count++;
                    sums += i;
                } else {
                    count += 2;
                    sums += i + d;
                }

                if (count > 4) return 0;
            }
        }
        return count == 4 ? sums : 0;
    }
}
