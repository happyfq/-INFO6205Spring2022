import java.util.*;

public class topKFrequentWords {
}
class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        List<String> res = new ArrayList<>(k);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>((s1, s2) -> {
            if (map.get(s1).equals(map.get(s2))) {
                return s2.compareTo(s1);
            } else {
                return map.get(s1) - map.get(s2);
            }
        });
        for (String s : map.keySet()) {
            heap.offer(s);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        while (heap.size() > 0) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}