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
        if(head == null || head.next == null)
            return head;
        ListNode nextHead = head;
        for (int i = 0; i < k; i++) {
            if(nextHead == null)
                return head;
            nextHead = nextHead.next;
        }
        ListNode newHead = reverse(head, nextHead);
        head.next = reverseKGroup(nextHead, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode nextHead) {
        ListNode newHead = null;
        ListNode cur = head;
        while(cur != nextHead) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
}