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
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        if ((list1 == null) && (list2 == null)) {
            return dummy.next;
        }

        while ((list1 != null) && (list2 != null)) {
            if (list1.val <= list2.val) {               // put list1.val next in the new LL
                tail.next = new ListNode(list1.val);
                list1 = list1.next;                     // go to next value in list1

            } else if (list2.val < list1.val) {         // put list2.val next in the new LL
                tail.next = new ListNode(list2.val);
                list2 = list2.next;                     // go to next value in list2
            }

            tail = tail.next;           // move tail
        }

        while (list1 != null) {         // list2 empty already
            tail.next = new ListNode(list1.val);
            list1 = list1.next;         // go to next value in list1
            tail = tail.next;           // move tail
        }

        while (list2 != null) {         // list1 empty already
            tail.next = new ListNode(list2.val);
            list2 = list2.next;         // go to next value in list2
            tail = tail.next;           // move tail
        }

        return dummy.next;
    }
}