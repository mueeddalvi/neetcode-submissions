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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2, curr3 = null;
        int carry = 0;
        ListNode head = new ListNode(0);
        curr3 = head;
        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carry;
            carry = sum / 10;
            curr3.next = new ListNode(sum % 10);
            curr1 = curr1.next;
            curr2 = curr2.next;
            curr3 = curr3.next;
        }

        while (curr1 != null) {
            int sum = curr1.val + carry;
            carry = sum / 10;
            curr3.next = new ListNode(sum % 10);
            curr1 = curr1.next;
            curr3 = curr3.next;
        }

        while (curr2 != null) {
            int sum = curr2.val + carry;
            carry = sum / 10;
            curr3.next = new ListNode(sum % 10);
            curr2 = curr2.next;
            curr3 = curr3.next;
        }

        if (carry > 0)
            curr3.next = new ListNode(carry);
        return head.next;
    }
}
