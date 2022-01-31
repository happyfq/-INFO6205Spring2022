package assignment1;

import java.util.ArrayList;
import java.util.List;

public class findKClosestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k=4,x=3;
        Solution658 s = new Solution658();
        System.out.println(s.findClosestElements(arr,k,x));
    }
}
class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l =0;
        int r =arr.length-1;
        int remain = arr.length-k;
        while(remain>0){
            if(x-arr[l]<=arr[r]-x){
                r--;
            }else{
                l++;
            }
            remain--;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=l;i<l+k;i++){
            res.add(arr[i]);
        }
        return res;
    }
}