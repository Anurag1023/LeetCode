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

        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;

            temp = temp.next.next;
        }

        temp = head;
        while (temp != null) {
            temp.next.random = temp.random == null ? null : temp.random.next;

            temp = temp.next.next;
        }

        Node dummy = new Node(0);
        Node curr = dummy;
        temp = head;

        while (temp != null) {
            Node copy = temp.next;

            temp.next = copy.next; 

            curr.next = copy; 
            curr = copy;

            temp = temp.next;
        }

        return dummy.next;
    }
}