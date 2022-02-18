package INFO6205Spring2022.assignment3.src.main.java;
import java.util.ArrayList;
import java.util.List;

public class palindromeLinkedList234 {
}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nums.add(cur.val);
            cur = cur.next;
        }
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            if (!nums.get(l).equals(nums.get(r))) {//注意这里有get
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}