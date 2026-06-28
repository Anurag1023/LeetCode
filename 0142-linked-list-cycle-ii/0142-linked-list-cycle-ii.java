/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        boolean loop = false;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                loop = true;
                break;
            }
        }

        if(!loop) return null;
        else{
            slow = head;
            while(slow!=fast){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
}