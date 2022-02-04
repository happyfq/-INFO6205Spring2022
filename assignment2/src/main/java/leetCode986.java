import java.util.ArrayList;
import java.util.List;
public class leetCode986 {
}
class Solution986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        int lenA = A.length, lenB = B.length;
        while(i < lenA && j < lenB) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if(start <= end) {
                list.add(new int[]{start, end});
            }
            if(A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}