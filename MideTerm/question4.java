import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution4 {
    public List<List<int[]>> mergeInt(int[][] intervals) {
        if (intervals == null) return null;
        List<List<int[]>> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                list.add(intervals[i]);
            } else if (intervals[i][1] <= intervals[i + 1][0]) {
                intervals[i][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                intervals[i][1] = Math.max(intervals[i + 1][1], intervals[i + 1][1]);
                list.add(intervals[i]);
            }
        }
        res.add(list);
        return res;
    }
}
