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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next, t1 = null, t2 = null, prev = null, curr = null, first=head;

        // find mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow at mid
        // reverse second half
        ListNode second = slow.next;
        curr = second;
        slow.next = null;

        while (curr != null) {
            t1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t1;
        }
        second=prev;
        // change ordering
        first=head;
        while (second!=null){
            t1=first.next;
            t2=second.next;

            first.next=second;
            second.next=t1;

            first=t1;
            second=t2;

        }
    }
}
