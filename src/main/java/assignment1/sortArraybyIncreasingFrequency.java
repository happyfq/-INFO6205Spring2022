package assignment1;
import java.util.Arrays;

public class sortArraybyIncreasingFrequency {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        Solution1636 s = new Solution1636();
        System.out.println(Arrays.toString(s.frequencySort(nums)));
    }
}
class Solution1636 {
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        for (int num : nums){
            count[num + 100] ++;
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = 201 * count[nums[i] + 100] - nums[i] + 100;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            nums[i] = 100 - nums[i] % 201;
        }
        return nums;
    }
}
