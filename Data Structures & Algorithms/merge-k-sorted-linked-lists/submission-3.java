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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        if(lists.length==0){
            return res.next;
        }
        ListNode head = lists[0];
        ListNode dummy=new ListNode(0);
        ListNode prev=new ListNode(0);

        res.next = head;
        ListNode t = head;
        ListNode temp=null;
        if(head==null){
            return null;
        }
        for (int i = 1; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                prev=res;
                t=res.next;

                while(t!=null && t.val<=curr.val){
                    prev=t;
                    t=t.next;
                }

                temp=curr.next;
                prev.next=new ListNode(curr.val,t);
                curr=temp;

            }
        }
        return res.next;
    }
}
