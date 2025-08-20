/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * Deletes the given node from a singly linked list when only that node is provided.
     * Assumption: node is not the tail (node.next != null).
     */
    public void deleteNode(ListNode node) {
        // Copy the next node's data into this node
        node.val = node.next.val;
        // Skip over the next node
        node.next = node.next.next;
    }

    // --- Helpers for demo/testing ---
    static ListNode build(int... arr) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int x : arr) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummy.next;
    }

    static ListNode find(ListNode head, int target) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val == target) return cur;
        }
        return null;
    }

    static void print(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) sb.append(" -> ");
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }

    // Simple test harness
}