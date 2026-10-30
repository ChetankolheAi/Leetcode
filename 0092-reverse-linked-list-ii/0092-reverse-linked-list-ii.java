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

        ListNode temp = head;
        ListNode tempprev = null;
        int count = 1;
    
        while(temp.next!=null && count<left)
        {
            tempprev = temp;
            temp=temp.next;
            count++;
        }
        if(temp.next == null) return head;

        
        ListNode FirstConnect = tempprev;
        ListNode LastConnect = temp;
        
        
        ListNode prev = null;
        ListNode crr = temp;

        //System.out.println(crr.val);
    
        while(crr!=null && count<=right ){
         
            ListNode next1 = crr.next;
            crr.next = prev;
            if(count == right){
                LastConnect.next = next1;
                break;
            }
            prev = crr;
            crr = next1;
            count++;
        }
        if(FirstConnect!=null) FirstConnect.next = crr;
        else if(FirstConnect==null) return crr;
        return head;
    }
}