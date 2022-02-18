/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = head;
        ListNode f = head.next;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode tmp = s.next;
        s.next = null;
        head = sortList(head);
        tmp = sortList(tmp);
        return merge(head, tmp);
    }

    public ListNode merge(ListNode head, ListNode tmp) {
        ListNode node1 = head;
        ListNode node2 = tmp;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (node2 != null && node1 != null) {
            if (node1.val < node2.val) {
                pre.next = node1;
                pre = node1;
                node1 = node1.next;
            } else {
                pre.next = node2;
                pre = node2;
                node2 = node2.next;
            }
        }
        if (node2 != null) {
            pre.next = node2;
        }
        if (node1 != null) {
            pre.next = node1;
        }
        return dummy.next;
    }
}