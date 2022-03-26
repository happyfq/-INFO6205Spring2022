import java.util.Arrays;
class Solution1 {
    public String missPart(int[] nums) {
        Arrays.sort(nums);
        StringBuffer res = new StringBuffer();
        if (nums[nums.length - 1] < 0 || nums[0] > 99) return res.toString();
        if (nums[0] != 0) res.append(0).append("->").append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                if (nums[i - 1] + 1 == nums[i] - 1) {
                    res.append(nums[i - 1] + 1).append("->").append(",");
                } else if (nums[i - 1] + 1 != nums[i] - 1) {
                    res.append(nums[i - 1] + 1).append("->").append(nums[i] - 1).append(",");
                }
            }
        }
        if (nums[nums.length-1] <= 99) res.append(nums[nums.length - 1]).append("->").append(99);
        return res.toString();
    }
}