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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode first=head;
        ListNode k1=head;
        
        int count =0;
        if (head == null || head.next == null || k == 0) return head;

        while(k1!=null){
            count++;
            k1=k1.next;
        }
        k=k%count;
        if(k==0) return head;

        k1=head;
        for(int i=1;i<count-k;i++){
            k1=k1.next;
        }
        ListNode newList=k1.next;
        k1.next=null;

        ListNode ans=newList;
        ListNode prev=null;

        while(newList!=null){
            prev=newList;
            newList=newList.next;
        }
       if (prev != null) {
            prev.next = first;
        }
        return ans;
    }
}