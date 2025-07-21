/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        
        ListNode* temp=head;
        ListNode* temp1=nullptr;
        ListNode* temp2=nullptr;
        int count=-1;
        if(!head || head->next==nullptr){
            return head;
        }
        while(temp!=nullptr){
            count=temp->val;
            temp1=temp;
            temp=temp->next;
            if(temp!=nullptr && count==temp->val ){
            while(temp!=nullptr && count==temp->val  ){
              temp=temp->next;
            }
            
            if(temp2==nullptr){
              head=temp;
               
            }
            else{
            temp2->next=temp;}
            
        }else{
            if(temp2==nullptr){
                temp2=head;
            }
            else{temp2=temp2->next;}
        }
       
    } return head;

    }
};