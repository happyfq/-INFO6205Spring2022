class leetCode274 {
}

public class h_Index {
    public int hIndex(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];//这里必须+1，不然下标会越界
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {//注意这里倒着加
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }
}
