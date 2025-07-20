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
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode list1 = ListNode.fromArray(new int[]{4, 2, 1, 3});
        ListNode sorted1 = sol.sortList(list1);
        ListNode.printList(sorted1); // [1, 2, 3, 4]

        ListNode list2 = ListNode.fromArray(new int[]{-1, 5, 3, 4, 0});
        ListNode sorted2 = sol.sortList(list2);
        ListNode.printList(sorted2); // [-1, 0, 3, 4, 5]

        ListNode list3 = ListNode.fromArray(new int[]{});
        ListNode sorted3 = sol.sortList(list3);
        ListNode.printList(sorted3); // []
    }
}
