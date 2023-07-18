import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/* 
 * INSERTION
 * DELETION
 * SERCHING
 * TRAVERSAL
 */
class BinaryTreeNode {
    int data;
    BinaryTreeNode left;// Left child with reference
    BinaryTreeNode right;// right child with reference

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}

class OperationsOnBinaryTree {
    String nameOfNode = "root";
    Scanner I = new Scanner(System.in);

    BinaryTreeNode addANode() {
        System.out.println("Enter the " + nameOfNode + " data or enter -1 to exit from that direction");
        int data = I.nextInt();
        if (data == -1)
            return null;
        // We will prepare a node...
        BinaryTreeNode node = new BinaryTreeNode(data);

        /*
         * If we dont want to exit so we will first insert in the left node...
         * And we will keep on inserting it to the left node...
         * Untill we get -1...
         */
        nameOfNode = "left";
        node.left = addANode();// recursion

        // Backtrack to go to the right
        /************************************************************/
        nameOfNode = "right";
        node.right = addANode();

        // Backtrack to go to the root
        /************************************************************/
        nameOfNode = "root";
        return node;

    }

    void print(BinaryTreeNode root) {
        // If no tree exist...
        if (root == null)
            return;
        // We are going to go in depth utill we get null
        // Easily done with recursion....
        // Doing Depth First Traversal(DFT)
        String result = "";
        result += root.data + " --> ";
        // Checking the existance of left node...
        if (root.left != null) {
            result += " Left " + root.left.data;
        }
        if (root.right != null) {
            result += " Right " + root.right.data;
        }
        System.out.println(result);
        print(root.left);
        print(root.right);

    }

    void preOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return;
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    void preOrderTraversalInIterative(BinaryTreeNode root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);// 10 is pushed in stack
        while (!stack.isEmpty()) {
            BinaryTreeNode currentNode = stack.pop();
            System.out.print(currentNode.data + " --> " + " ");
            // Now we have to push left and right element.....
            if (currentNode.right != null)
                stack.push(currentNode.right);
            if (currentNode.left != null)
                stack.push(currentNode.left);
        }

    }

    void preOrderTraversalInIterativeOptimised(BinaryTreeNode root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                if (currentNode.right != null)
                    stack.push(currentNode.right);
                currentNode = currentNode.left;
            }
            if (!stack.isEmpty())
                currentNode = stack.pop();

        }
        stack.pop();
    }

    void postOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);

    }

    void postOrderTraversalIterative(BinaryTreeNode root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                if (currentNode.right != null)
                    stack.push(currentNode.right);
                if (currentNode.left != null)
                    stack.push(currentNode.left);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.print(currentNode.data + " ");

        }

    }

    void inOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    void inOrderTraversalIteration(BinaryTreeNode root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode currentNode = root;
        while (currentNode != null && !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.right;

        }
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            System.out.print(currentNode.data + " ");
            if (currentNode.right != null)
                stack.push(currentNode.right);
        }

    }

    void breathFirstSearch(BinaryTreeNode root) {
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // Removing first element from queue
            BinaryTreeNode node = queue.removeFirst();
            System.out.print(node.data);

            // Put left and right in the queue
            if (node.left != null)
                queue.addLast(node.left);
            if (node.right != null)
                queue.addLast(node.right);
        }
    }

    void breathFirstSearch2(BinaryTreeNode root) {
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // Removing first element from queue
            // BinaryTreeNode node=queue.removeFirst();
            int countQueue = queue.size();
            for (int i = 0; i < countQueue; i++) {
                BinaryTreeNode currentNode = queue.poll();
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null)
                    queue.addLast(currentNode.left);
                if (currentNode.right != null)
                    queue.addLast(currentNode.right);
            }
            System.out.println();
        }

    }

    static int heightR(BinaryTreeNode root) {
        if (root == null)
            return 0;// Empty tree height is zero
        int leftHeight = heightR(root.left);
        int rightHeight = heightR(root.right);
        int value = Math.max(leftHeight, rightHeight);
        return value + 1;

    }

    static int noOfNodes(BinaryTreeNode root) {
        // Time Complexity--BigO(depth);
        if (root == null)
            return 0;// Empty tree height is zero
        int counter = 1;
        // Visit to Node(1)
        counter += heightR(root.left);
        counter += heightR(root.right);
        return counter;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Scanner I = new Scanner(System.in);
        OperationsOnBinaryTree obt = new OperationsOnBinaryTree();
        BinaryTreeNode root = null;
        while (true) {
            System.out.println("Binary Tree Operation");
            System.out.println("1..Add a node");
            System.out.println("2..Print the binary tree");
            System.out.println("2..Exit from the binary tree");

            System.out.println("Enter the choice");
            int choice = I.nextInt();
            switch (choice) {
                case 1:
                    root = obt.addANode();
                    break;
                case 2:
                    // obt.print(root);
                    // obt.preOrderTraversalInIterative(root);
                    // obt.inOrderTraversalIteration(root);
                    obt.postOrderTraversalIterative(root);
                    break;
                case 3:
                    System.exit(0);
                    ;

            }

        }
        // I.close();

    }
}
