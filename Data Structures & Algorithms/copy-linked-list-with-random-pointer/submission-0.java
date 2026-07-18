/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head, prev = null, newNode = null;
        Node dummy = new Node(0);
        Map<Node, Node> map = new HashMap<>();
        while (curr != null) {
            newNode = new Node(curr.val);
            map.putIfAbsent(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        map.put(null,null);
        while (curr != null) {
            if (map.containsKey(curr)) {
                newNode=map.get(curr);
                newNode.next=map.get(curr.next);
                newNode.random=map.get(curr.random);
            }
            curr=curr.next;
        }

        return map.get(head);
    }
}
