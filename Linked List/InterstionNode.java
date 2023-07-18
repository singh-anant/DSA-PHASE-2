
//   Definition for singly-linked list.

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null)
            return headA;
        if (headB == null)
            return headB;

        Set<ListNode> addressOfNode = new HashSet<>();

        while (headA != null) {

            addressOfNode.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (addressOfNode.contains(headB))
                return headB;

            headB = headB.next;
        }

        return null;
    }

    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        while (lenA > lenB) {
            lenA--;
            headA = headA.next;
        }

        while (lenB > lenA) {
            lenB--;
            headB = headB.next;
        }

        // Now both heads are at same distance from intersection
        // Start moving them both until they meet
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int getListLength(ListNode head) {
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

}