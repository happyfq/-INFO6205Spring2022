package assignment1;

public class h_Index {
    public static void main(String[] args) {
        int[] nums={3,0,6,1,5};
        System.out.println(new Solution274().hIndex(nums));
    }
}
class Solution274 {
    public int hIndex(int[] citations) {
        int n = citations.length, cnt = 0;
        int[] count = new int[n + 1];//这里必须+1，不然下标会越界
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                count[n]++;
            } else {
                count[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {//注意这里倒着加
            cnt += count[i];
            if (cnt >= i) {
                return i;
            }
        }
        return 0;
    }
}
