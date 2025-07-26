class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode check = curr;
            for (int i = 0; i < k; i++) {
                if (check == null) return dummy.next;
                check = check.next;
            }

            // Reverse k nodes
            ListNode prev = null;
            ListNode tail = curr;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect reversed part to the previous and next sections
            prevGroupEnd.next = prev;
            tail.next = curr;

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = tail;
        }
    }
}
