package assignment1;

import java.util.Arrays;

public class sortColors {
    public static void main(String[] args) {
        int[] nums ={2,0,2,1,1,0};
        Solution s = new Solution();
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
class Solution{
    public void sortColors(int[] nums) {
        int l=0;
        int r =nums.length;
        int i=0;
        if (r < 2) {
            return;
        }
        while(i<r){
            if(nums[i] == 0){
                swap(nums,i,l);
                l++;
                i++;

            }
            else if(nums[i]==1){
                i++;
            }
            else{
                r--;
                swap(nums,i,r);

            }
        }
    }
    public void swap(int[] nums,int index1,int index2){
        int temp=nums[index1];
        nums[index1] = nums[index2];
        nums[index2] =temp;

    }
}