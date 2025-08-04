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
    public ListNode insertionSortList(ListNode head) {
        // Dummy node helps simplify insertion at the head
        ListNode dummy = new ListNode(0);
        ListNode current = head;

        while (current != null) {
            ListNode prev = dummy;

            // Find the correct place to insert the current node
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // Save the next node to process
            ListNode nextTemp = current.next;

            // Insert current node between prev and prev.next
            current.next = prev.next;
            prev.next = current;

            current = nextTemp;
        }

        return dummy.next;
    }
}