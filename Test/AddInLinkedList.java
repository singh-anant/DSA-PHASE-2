import java.util.*;

class Solution {
    public Node addTwoLists(Node l1, Node l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        Node temp, temp1, temp2;
        temp1 = l1;
        temp2 = l2;
        Node head = new Node(0);
        Node ptr = head;
        int carry = 0;
        int value;
        while (temp1 != null || temp2 != null) {
            if (temp1 == null && temp2 != null) {
                value = temp2.val + carry;
                temp = new Node(value % 10);
                ptr.next = temp;
                ptr = ptr.next;
                temp2 = temp2.next;
                carry = value / 10;
            } else if (temp1 != null && temp2 == null) {
                value = temp1.val + carry;
                temp = new Node(value % 10);
                ptr.next = temp;
                ptr = ptr.next;
                temp1 = temp1.next;
                carry = value / 10;
            } else {
                value = temp1.val + temp2.val + carry;
                temp = new Node(value % 10);
                ptr.next = temp;
                ptr = ptr.next;
                temp1 = temp1.next;
                temp2 = temp2.next;
                carry = value / 10;
            }
        }
        if (carry != 0) {
            temp = new Node(carry);
            ptr.next = temp;
        }
        return reverse(head.next);
    }

    public Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        int size;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}

class Node {
    int val;
    Node next;

    Node(int d) {
        val = d;
        next = null;
    }
}

public class AddInLinkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int val = sc.nextInt();

        Node first = new Node(val);
        Node tail = first;
        for (int i = 0; i < n - 1; i++) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }

        int m = sc.nextInt();
        val = sc.nextInt();

        Node second = new Node(val);
        tail = second;
        for (int i = 0; i < m - 1; i++) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }

        Solution g = new Solution();
        Node res = g.addTwoLists(first, second);
        printList(res);
    }

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }
}
