/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* temp = head;
        ListNode* prev = NULL;
        while (temp != NULL) {
            if (prev != NULL && temp->val == val) {
                prev->next = prev->next->next;
                temp = temp->next;
            }
            else if (prev == NULL && temp->val == val) {
                temp = temp->next;
                head = head->next;
            }
            else {
                prev = temp;
                temp = temp->next;
            }
        }
        return head;
    }
};