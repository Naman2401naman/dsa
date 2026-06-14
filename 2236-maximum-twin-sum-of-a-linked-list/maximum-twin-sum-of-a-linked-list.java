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
    public int pairSum(ListNode head) {
        ListNode c=head;
        int co=0;
        while(c!=null){
            co++;
            c=c.next;

        }
        Stack<Integer> st=new Stack<>();
        c=head;
        int lp=(co/2)-1;
        for(int i=0;i<=lp;i++){
            st.add(c.val);
            c=c.next;
        }
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<=lp;i++){
            maxi=Math.max(maxi,st.pop()+c.val);
            c=c.next;
        }
        return maxi;
    }
}