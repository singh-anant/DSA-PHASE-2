import java.util.ArrayList;
import java.util.Collections;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    static void reverse(ArrayList<Integer> arr, int low, int high) {
        while (low < high) {
            Collections.swap(arr, low, high);
            low++;
            high--;
        }
    }

    public ListNode rotateRight(ListNode head, int rotation) {
        if (head == null)
            return head;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            arr.add(p.val);
            p = p.next;
        }
        rotation %= arr.size();
        if (rotation < 0)
            rotation = arr.size() + rotation;
        // reversing the first Half
        reverse(arr, 0, arr.size() - 1 - rotation);
        // reversing the secont half
        reverse(arr, arr.size() - rotation, arr.size() - 1);
        // reversing the whole array
        reverse(arr, 0, arr.size() - 1);
        p = head;
        for (int i = 0; i < arr.size(); i++) {
            p.val = arr.get(i);
            p = p.next;
        }
        return head;
    }
}