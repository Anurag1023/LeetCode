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
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next==null) return head;

        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }

        k = k%size;
        temp = head;
        ListNode target = head;

        for(int i=0;i<size-k;i++) target = target.next;

        ListNode l1 = head;
        ListNode rev1 = reverse(head,target);
        l1.next = reverse(target,null);

        return reverse(rev1,null);

    }

    private ListNode reverse(ListNode head, ListNode target){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while(curr!=target){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}