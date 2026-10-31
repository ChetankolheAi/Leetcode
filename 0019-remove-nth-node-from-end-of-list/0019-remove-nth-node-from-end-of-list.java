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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==1 && head.next==null) return null;
        if(head==null) return null;
        ListNode temp = head;
        int Length = 0;
        while(temp!=null){
            Length++;
            temp=temp.next;
        }
        int NodeNumber = Length-n;
        
        if(NodeNumber == 0){
            head = head.next;
            return head;
        }
        temp = head;
        int count  = 1;
        while(temp!=null && count<NodeNumber){
            temp=temp.next;
            count++;
        }
        if(temp.next==null){
            return head;
        }
        ListNode next = temp.next.next;
        temp.next = next;
        return head;

    }
}