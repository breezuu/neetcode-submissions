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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int digit = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            int total = carry;
            
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }
            
            carry = total / 10;                     // the carry will be handled by the 'while' loop for addition with the NEXT digits in line in 'l1' and 'l2'
            digit = total % 10;                     // obtains the remaining 'ones' digit after taking out the 'carry' digit
            tail.next = new ListNode(digit);   // always put the 'ones' digit next in line
            tail = tail.next;                       // move the tail to append the next value in the next iteration
        }

        return dummy.next;
    }
}