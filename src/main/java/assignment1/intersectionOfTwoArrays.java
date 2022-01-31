package assignment1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class intersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1= {1,2,2,1};
        int[] nums2={2,2};
        Solution349 s = new Solution349();
        System.out.println(Arrays.toString(s.intersection(nums1,nums2)));
    }
}
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
        Set<Integer> reset = new HashSet<>();
        for(int j : nums2){
            if(set.contains(j)){
                reset.add(j);
            }
        }
        int[] res =new int[reset.size()];
        int index=0;
        for(int n:reset){
            res[index++]=n;
        }
        return res;
    }
}