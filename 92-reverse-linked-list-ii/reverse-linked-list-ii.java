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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        // move prev to node before "left"
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // start reversing from here
        ListNode curr = prev.next;
        ListNode ahead = null;
        ListNode last = null;

        for (int i = 0; i < right - left + 1; i++) {
            ahead = curr.next;
            curr.next = last;
            last = curr;
            curr = ahead;
        }

        // reconnect
        prev.next.next = curr; // tail connects to remainder
        prev.next = last;      
        return dummy.next;
    }
}
