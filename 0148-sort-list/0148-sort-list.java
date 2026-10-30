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
    public ListNode sortList(ListNode head) {
        List<Integer>li = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            li.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(li);
        ListNode newHead = null;
        ListNode temp1 = null;
        for(int i=0;i<li.size();i++){
            ListNode newTemp = new ListNode(li.get(i));
            if(newHead==null){
                newHead = newTemp;
                temp1 = newHead;
                continue;
            }
            else{
                temp1.next = newTemp;
                temp1 = temp1.next;
            }

        }
        return newHead;
    }
}