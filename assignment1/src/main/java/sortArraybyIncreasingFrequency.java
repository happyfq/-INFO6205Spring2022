import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sortArraybyIncreasingFrequency {
}
class Solution1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        int[] arr = Arrays.stream(nums).boxed().sorted((o1, o2) -> {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            return count1 == count2 ? o2 - o1 : count1 - count2;
        }).mapToInt(Integer::intValue).toArray();
        return arr;
    }
}