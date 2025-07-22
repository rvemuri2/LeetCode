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
    public ListNode partition(ListNode head, int x) {
        // Dummy heads for the two partitions
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        // Tail pointers to build the two lists
        ListNode before = beforeHead;
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;           // Avoid cycle
        before.next = afterHead.next; // Connect the two partitions

        return beforeHead.next; // Skip dummy node
    }
    public static void printList(ListNode node) {
    while (node != null) {
        System.out.print(node.val + " ");
        node = node.next;
    }
    System.out.println();
}

public static void main(String[] args) {
    Solution sol = new Solution();

    ListNode head1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
    printList(sol.partition(head1, 3)); // Output: 1 2 2 4 3 5

    ListNode head2 = new ListNode(2, new ListNode(1));
    printList(sol.partition(head2, 2));
    }

}

