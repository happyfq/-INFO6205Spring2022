import java.util.Arrays;
import java.util.Stack;

public class nextGreaterNodeInLinkedList1019 {
}

class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        int[] ans = new int[10000];
        Stack<int[]> stack = new Stack<>();
        ListNode node = head;
        int count = 0;
        while (node != null) {
            while (!stack.isEmpty() && node.val > stack.peek()[0]) {
                int[] pop = stack.pop();
                ans[pop[1]] = node.val;
            }
            stack.push(new int[]{node.val, count});
            node = node.next;
            count++;
        }
        return Arrays.copyOf(ans, count);
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