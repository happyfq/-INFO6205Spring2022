import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode18 {
}

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (r > l && nums[r] == nums[r - 1]) r--;
                        while (r > l && nums[l] == nums[l + 1]) l++;
                        l++;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}