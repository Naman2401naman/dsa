public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                length = getCycleLength(slow);
                break;
            }
        }

        // No cycle found
        if (length == 0) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while (length > 0) {
            second = second.next;
            length--;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first; 
    }

    private int getCycleLength(ListNode node) {
        int length = 1;
        ListNode current = node.next;

        while (current != node) {
            current = current.next;
            length++;
        }

        return length;
    }
}
