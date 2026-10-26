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
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode temp = head;
        ListNode temp1 = null;
        ListNode temp2 = null;
        while(temp!=null){
            if(temp.val<x){
                if(head1==null){
                    head1 = temp;
                    temp1 = head1;
                }
                else{
                    temp1.next = temp;
                    temp1 = temp1.next;
                }
                temp = temp1.next;
                temp1.next = null;
            }
            else {

                if(head2==null){
                    head2 = temp;
                    temp2 = head2;
                }
                else{
                    temp2.next = temp;
                    temp2 = temp2.next;
                }
                temp = temp2.next;
                temp2.next = null;
            }
        }
        if(head1 == null) return head2;
        if(head2==null) return head1;
        
        temp1.next = head2;
        
        return head1;
    }
}