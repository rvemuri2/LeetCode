/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 */

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = head;

        while (current != null) {
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            ListNode nextTemp = current.next;

            current.next = prev.next;
            prev.next = current;

            current = nextTemp;
        }

        return dummy.next;
    }
}