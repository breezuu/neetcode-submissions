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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;       // cover nodes one by one
            fast = fast.next.next;  // skip ahead of the 'slow' node to detect cycles

            if (slow == fast) {     // fast lapped slow (same node object, not same value) → cycle detected
                return true;
            }
        }

        return false;
    }
}
