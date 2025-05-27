# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
class Solution:
    def deleteDuplicates(self, head):
        if not head:
            return head
        current = head
        while current.next:
            if current.val == current.next.val:
                current.next = current.next.next
            else:
                current = current.next

        return head