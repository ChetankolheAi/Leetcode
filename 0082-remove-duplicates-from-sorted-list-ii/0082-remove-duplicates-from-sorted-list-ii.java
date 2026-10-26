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
    public ListNode deleteDuplicates(ListNode head) {
        
        Map<Integer,Integer>map = new HashMap<>();
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){

            if(map.containsKey(temp.val)){

                map.put(temp.val ,map.get(temp.val)+1);
                ListNode next = temp.next;
                temp.next = null;
                prev.next = next;
                temp = next;
                continue;

            }
            else map.put(temp.val , 1);
            prev = temp;
            temp = temp.next;
        }
        temp = head;
        prev = null;

        while(temp!=null){

            if(map.containsKey(temp.val) && map.get(temp.val)>1){

                if(temp.next==null && prev!=null){
                    prev.next = null;
                    break;
                }
                else if(temp.val==head.val){
                    head = temp.next;
                    temp.next = null;
                    temp = head;
                    continue;
                }
                else if(temp.next!=null){
                    ListNode next = temp.next;
                    temp.next = null;
                    prev.next = next;
                    temp = next;
                    continue;
                }
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
      
    }
}