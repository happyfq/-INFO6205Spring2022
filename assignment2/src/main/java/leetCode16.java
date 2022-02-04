import java.util.Arrays;
public class leetCode16 {
}
class Solution16 {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int best =10000000;
            for (int i = 0; i < n; ++i) {
                int j = i + 1, k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return target;
                    }
                    if (Math.abs(sum - target) < Math.abs(best - target)) {
                        best = sum;
                    }
                    if (sum > target) {
                        k = k - 1;
                    } else {
                        j = j + 1;
                    }
                }
            }
            return best;
        }
    }