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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy =new ListNode(0);
        dummy.next=head;
        ListNode temp=dummy;
        ListNode m=dummy;
        while(temp!=null){
            
            ListNode n=temp;
            int sum=0;
            while(n!=null){
                
                sum+=n.val;
                if(sum==0){
                    m.next=n.next;
                    n=m;
                }
                n=n.next;
            }
            m=temp;
            temp=temp.next;
            
        }
        return dummy.next;
    }
}