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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;       // save the next node
            curr.next = prev;       // reverse the pointer
            prev = curr;            // move 'prev' forward
            curr = next;            // the new, current node will be the next node saved at the start
        }

        return prev;
    }
}
