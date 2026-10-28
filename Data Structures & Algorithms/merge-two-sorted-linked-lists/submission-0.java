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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode left = list1;
        ListNode right = list2;
        ListNode head = new ListNode(0, null);
        ListNode result = head;         // points to the start of the LL answer

        while ((left != null) && (right != null)) {
            if (left.val < right.val) {
                result.next = new ListNode(left.val);
                left = left.next;       // move the ptr of the left LL
            } else {
                result.next = new ListNode(right.val);
                right = right.next;     // move the ptr of the right LL
            }

            result = result.next;       // move the ptr of the answer LL
        }

        while ((left != null) && (right == null)) {
            result.next = new ListNode(left.val);
            left = left.next;           // move the ptr of the left LL
            result = result.next;       // move the ptr of the answer LL
        }

        while ((left == null) && (right != null)) {
            result.next = new ListNode(right.val);
            right = right.next;         // move the ptr of the right LL
            result = result.next;       // move the ptr of the answer LL
        }

        return head.next;
    }
}