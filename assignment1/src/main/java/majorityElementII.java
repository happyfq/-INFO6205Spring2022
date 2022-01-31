import java.util.ArrayList;
import java.util.List;

public class majorityElementII {

}
class Solution {
    int candidate1;
    int candidate2;
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(candidate1 == nums[i] && count1 > 0){//前面两个判断必须写在最前面，相当于先加票，再看候选人
                count1++;
            }
            else if(candidate2 == nums[i] && count2 > 0){
                count2++;
            }
            else if(count1 == 0){
                candidate1 = nums[i];
                count1++;
            }
            else if(count2 == 0){
                candidate2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        count1 = 0; count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(candidate1 == nums[i]) count1++;
            if(candidate2 == nums[i]) count2++;
        }
        if(count1 > nums.length/3 ) result.add(candidate1);
        if(count2 > nums.length/3 && candidate1 != candidate2) result.add(candidate2);

        return result;

    }
}