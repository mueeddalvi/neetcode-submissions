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
        if (lists.length == 0) {
            return res.next;
        }
        ListNode prev = new ListNode(0);
        ListNode t = null, temp = null;
        if (lists.length == 1 && lists[0] == null) {
            return null;
        }
        res.next = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                prev = res;
                t = res.next;

                while (t != null && t.val <= curr.val) {
                    prev = t;
                    t = t.next;
                }

                temp = curr.next;
                prev.next = new ListNode(curr.val, t);
                curr = temp;
            }
        }
        return res.next;
    }
}
