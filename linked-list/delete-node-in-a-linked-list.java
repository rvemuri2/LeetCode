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
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: head = [4,5,1,9], delete node with value 5 -> [4,1,9]
        ListNode head1 = build(4,5,1,9);
        System.out.print("Before: "); print(head1);
        sol.deleteNode(find(head1, 5));
        System.out.print("After : "); print(head1); // 4 -> 1 -> 9

        // Example 2: head = [4,5,1,9], delete node with value 1 -> [4,5,9]
        ListNode head2 = build(4,5,1,9);
        System.out.print("Before: "); print(head2);
        sol.deleteNode(find(head2, 1));
        System.out.print("After : "); print(head2);
    }
}