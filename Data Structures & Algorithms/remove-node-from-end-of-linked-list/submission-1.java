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

        int length = 0,i=0;

        ListNode curr=head,prev=null;

        while(curr!=null){
            length++;
            curr=curr.next;
        }
        curr=head;

        while(i!=(length-n)){
            prev=curr;
            curr=curr.next;
            i++;
        }
        
        if(prev!=null){
            prev.next=curr.next;
            return head;
        }
        else if(length>1){
            head=head.next;
            return head;
        }
        
        return prev;
    }
}
