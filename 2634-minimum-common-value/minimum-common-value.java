class Solution {

    public int getCommon(int[] nums1, int[] nums2) {

        for (int x : nums1) {

            int low = 0;
            int high = nums2.length - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (nums2[mid] == x) {
                    return x;
                }

                else if (nums2[mid] < x) {
                    low = mid + 1;
                }

                else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}