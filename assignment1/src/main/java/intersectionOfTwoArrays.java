import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class intersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {1,2};
        System.out.println(Arrays.toString(new Solution349().intersection(nums1,nums2)));
    }
}
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        Set<Integer> resSet = new HashSet<>();
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        int[] resArr = new int[resSet.size()];
        int index = 0;//这个index必须放在下面这个for循环外面（之前）
        //将结果几何转为数组
        for (int i : resSet) {
            resArr[index++] = i;
        }
        return resArr;
    }
}
