import java.util.ArrayList;
import java.util.List;

public class pancakeSorting {
}
class Solution969 {
    public List<Integer> pancakeSort(int[] arr) {
        // 还是把最大的索引找出来，把最大值 翻转到前面 然后 在统一翻转全部未排序的，把最大的反转到最后未排序的位置上。
        // 区别就是维护的是 索引，而不是模拟整个翻转的过程
        int length = arr.length;
        int[] table = new int[length];
        for(int i = 0; i < length; i++){
            arr[i]--;
            table[arr[i]] = i;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = length - 1; i >=0; i--){
            if(table[i] == i) continue;
            int temp = table[i];
            list.add(temp+1);
            list.add(i+1);
            for(int j = 0; j < i ; j++){
                if(table[j] < temp){
                    table[j] = i - temp + table[j];
                }else{
                    table[j] = i - table[j];
                }
            }
        }
        return list;
    }
}