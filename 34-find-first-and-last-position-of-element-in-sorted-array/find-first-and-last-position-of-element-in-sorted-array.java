class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=firstelement(nums,target);
        int last=lastelement(nums,target);
        if(first!=-1 && last==-1){
            last=first;
        }
        return new int[]{first,last};
    }
        public static int firstelement(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result=-1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            

            if (nums[mid] == target) {
                result=mid; // Target found
                high=mid-1;
            } else if (nums[mid] < target) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return result;
    }
        public static int lastelement(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result=-1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result= mid; // Target found
                low=mid+1;
            } else if (nums[mid] < target) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return result;
    }   
}