from typing import Optional
from math import gcd

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        current = head

        while current and current.next:

            g = gcd(current.val, current.next.val)

            new_node = ListNode(g)

            new_node.next = current.next
            current.next = new_node

            current = new_node.next

        return head
