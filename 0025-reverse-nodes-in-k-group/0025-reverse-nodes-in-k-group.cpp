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
    int length(ListNode* head){
         ListNode* temp=head;
        int count=0;
        while(temp!=NULL){
            temp=temp->next;
            count++;
        }
    return count;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* prev=NULL;
        ListNode* crrt=head;
        ListNode* next;
        
        int count=0;
        while(crrt!=NULL && count<k ){
            next=crrt->next;
            crrt->next=prev;

            prev=crrt;
            crrt=next;
            count++;
        }
        if(crrt!=NULL){
            int lenght=length(next);
            if(lenght>=k){
                ListNode* newhead=reverseKGroup(next ,k);
                head->next=newhead;
            }
            else{
                head->next=next;
            }
        
        
        }
        return prev;
    }

        
};