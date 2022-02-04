public class leetCode153 {
}
class Solution153 {
    public static int findMin(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}