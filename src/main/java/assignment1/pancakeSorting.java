package assignment1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pancakeSorting {
    public static void main(String[] args) {
        int[] arr= {3,2,4,1};
        Solution969 s = new Solution969();
        System.out.println(s.pancakeSort(arr));
    }
}

class Solution969 {
        public List<Integer> pancakeSort(int[] arr) {
            List<Integer> res = new ArrayList();
            int len = arr.length;
            Integer[] reverse = new Integer[len];
            for (int i = 0; i < len; ++i)
                reverse[i] = i+1;
            Arrays.sort(reverse, (i, j) -> arr[j-1] - arr[i-1]);
            for (int i: reverse) {
                for (int f: res)
                    if (i <= f)
                        i = f+1 - i;
                res.add(i);
                res.add(len--);
            }

            return res;
        }
    }
