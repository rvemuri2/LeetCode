# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)  # Dummy node simplifies edge cases
        first = second = dummy

    # Move first pointer n+1 steps ahead (so second points to the node before the one to remove)
        for _ in range(n + 1):
            first = first.next

    # Move first to the end, maintaining the gap
        while first:
            first = first.next
            second = second.next

    # Remove the nth node from end
        second.next = second.next.next

        return dummy.next
        