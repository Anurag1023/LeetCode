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
    public ListNode removeNodes(ListNode head) {
        Deque<Integer> st = new LinkedList<>();

        ListNode curr = head;
        while(curr!=null){
            st.push(curr.val);
            curr = curr.next;
        }

        curr = new ListNode(st.pop());

        while(!st.isEmpty()){
            Integer val = st.pop();
            if(curr.val>val) continue;
            else{
                ListNode node = new ListNode(val);
                node.next = curr;
                curr = node;
            }
        }

        return curr;

    }
}