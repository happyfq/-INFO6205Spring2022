/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        int count = b - a + 2;
        ListNode cur2 = list1;
        int count2 = b + 1;
        while ((a - 1) > 0) {
            a--;
            cur = cur.next;
        }
        ListNode left = cur;
        while (count2 > 0) {
            cur2 = cur2.next;
            count2--;
        }
        ListNode right = cur2;
        left.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = right;
        return list1;
    }
}

