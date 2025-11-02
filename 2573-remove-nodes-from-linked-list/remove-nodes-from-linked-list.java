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
import java.util.*;

class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        // Traverse the linked list
        while (temp != null) {
            // Pop smaller values from the stack
            while (!stack.isEmpty() && stack.peek() < temp.val) {
                stack.pop();
            }
            stack.push(temp.val);
            temp = temp.next;
        }

        // Build new linked list from stack values
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : stack) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}
