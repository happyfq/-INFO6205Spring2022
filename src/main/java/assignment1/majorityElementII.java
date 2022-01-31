package assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class majorityElementII {
    public static void main(String[] args) {
        int[] nums= {3,2,3};
        Solution2 s = new Solution2();
        System.out.println(s.majorityElement(nums));
    }
}
class Solution2 {
    public List<Integer> majorityElement(int[] nums) {
        int num1=0;
        int num2=0;
        int cnt1=0;
        int cnt2=0;
        List<Integer> res = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            if(cnt1 != 0 && nums[i]==num1){
                cnt1++;
            }else if (cnt2!=0 && nums[i]==num2){
                cnt2++;
            }else if(cnt1 ==0){
                num1 = nums[i];
                cnt1++;
            }else if(cnt2 == 0){
                num2 = nums[i];
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        int count1=0;
        int count2=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] == num1){
                count1++;
            }
            else if(nums[i] == num2){
                count2++;
            }
        }
        if(count1>nums.length/3){
            res.add(num1);
        }
        if(count2>nums.length/3 && num1 != num2){
            res.add(num2);
        }
        return res;
    }
}