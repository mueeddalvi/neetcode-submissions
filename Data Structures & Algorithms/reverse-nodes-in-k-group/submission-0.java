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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode start=head, curr=head, temp=null, rev=null, prevTail=null;
        ListNode begin=new ListNode(0);
        begin.next=head;
        prevTail=begin;
        int i=1;

        while(curr!=null){
            curr=start;
            i=1;
            while(i<k && curr!=null){
                i++;
                curr=curr.next;
            }

            if(curr==null)
                break;
            temp=curr.next;
            curr.next=null;
            rev=reverse(start);
            prevTail.next=rev;
            prevTail=start;
            prevTail.next=temp;
            start=temp;        
        }
        return begin.next;
    }

    public ListNode reverse(ListNode head){
        ListNode prev=null, temp=null;

        while(head!=null){
            temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
}
