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
    public ListNode removeNodes(ListNode head) {
        List<Integer> li = new ArrayList<>();
        
        
        ListNode temp  = head;
        while(temp!=null){
            li.add(temp.val);
            temp = temp.next; 
        }
        temp = head;


        int maxi = Integer.MIN_VALUE;
        for(int i=li.size()-1;i>=0;i--){
            if(li.get(i)>=maxi){
                maxi = Math.max(maxi , li.get(i));
                li.set(i,-1);
            }
            
        }

        int j = 0;
        ListNode ans = null;
        ListNode temp2 = null;
        while(temp!=null){
            if(li.get(j)==-1){
                if(ans==null){
                    ans = temp;
                    temp2 = temp;
                }
                else{
                    temp2.next = temp;
                    temp2 = temp2.next;
                }
            }
            temp = temp.next;
            j++;
        }
        return ans;
        
    }
}