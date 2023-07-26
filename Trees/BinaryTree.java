import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

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
        stack.push(currentNode);
        while (!stack.isEmpty()) {
            while (currentNode != null) {
                if (currentNode.right != null)
                    stack.push(currentNode.right);
                if (currentNode.left != null)
                    stack.push(currentNode.left);
                currentNode = currentNode.left;
            }

            System.out.print(stack.pop().data + " ");

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
        int leftHeight = 1 + heightR(root.left);
        int rightHeight = 1 + heightR(root.right);
        int value = Math.max(leftHeight, rightHeight);
        return value;

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

    int maxLevel = 0;

    void printLeftView(BinaryTreeNode root, int currentlevel) {
        if (root == null)
            return;
        if (maxLevel < currentlevel) {
            System.out.println(root.data);
            maxLevel = currentlevel;
        }
        printLeftView(root.left, currentlevel + 1);
        printLeftView(root.right, currentlevel + 1);

    }

    void printLeftViewIterative(BinaryTreeNode root) {
        if (root == null)
            return;
        // Here we have done upcast...
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                BinaryTreeNode currentNode = queue.poll();
                if (i == 0)
                    System.out.print(currentNode.data);
                if (currentNode.left != null)
                    queue.add(currentNode.left);

                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }
    }

    void printRightViewIterative(BinaryTreeNode root) {
        if (root == null)
            return;
        // Here we have done upcast...
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                BinaryTreeNode currentNode = queue.poll();
                if (i == queueSize - 1)
                    // or
                    // if (i == 0)
                    System.out.print(currentNode.data);

                if (currentNode.right != null)
                    queue.add(currentNode.right);
                if (currentNode.left != null)
                    queue.add(currentNode.left);
            }
        }
    }

    void printRightView(BinaryTreeNode root, int currentlevel) {
        if (root == null)
            return;
        if (maxLevel < currentlevel) {
            System.out.println(root.data);
            maxLevel = currentlevel;
        }
        // Level by level it is incremented....
        printLeftView(root.right, currentlevel + 1);
        printLeftView(root.left, currentlevel + 1);
    }

    void printVerticalOrder(BinaryTreeNode root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        verticalOrder(root, 0, map);
        for (Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    void verticalOrder(BinaryTreeNode root, int distance, TreeMap<Integer, ArrayList<Integer>> map) {
        if (root == null)
            return;
        // When we will go left we will do -1
        // When we will go right we will do +1
        if (map.get(distance) == null) {
            // Create a fresh ArrayList
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(root.data);
            map.put(distance, arr);
        } else {
            // Add to the existing key...
            map.get(distance).add(root.data);
        }
        verticalOrder(root.left, distance - 1, map);
        verticalOrder(root.right, distance + 1, map);

    }

    void printtopView(BinaryTreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        topView(root, 0, map);
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    void topView(BinaryTreeNode root, int distance, TreeMap<Integer, Integer> map) {
        if (root == null)
            return;
        // When we will go left we will do -1
        // When we will go right we will do +1
        if (map.get(distance) == null) {
            // Create a fresh ArrayList
            map.put(distance, root.data);
        }
        topView(root.left, distance - 1, map);
        topView(root.right, distance + 1, map);

    }

    void printBottomView(BinaryTreeNode root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        bottomView(root, 0, map);
        for (Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue().get(m.getValue().size() - 1));
        }
    }

    void bottomView(BinaryTreeNode root, int distance, TreeMap<Integer, ArrayList<Integer>> map) {
        if (root == null)
            return;
        // When we will go left we will do -1
        // When we will go right we will do +1
        if (map.get(distance) == null) {
            // Create a fresh ArrayList
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(root.data);
            map.put(distance, arr);
        } else {
            // Add to the existing key...
            map.get(distance).add(root.data);
        }
        bottomView(root.left, distance - 1, map);
        bottomView(root.right, distance + 1, map);

    }

    void printDiagonalView(BinaryTreeNode root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        diagonalView(root, 0, map);
        for (Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    void diagonalView(BinaryTreeNode root, int distance, TreeMap<Integer, ArrayList<Integer>> map) {
        if (root == null)
            return;
        // When we will go left we will do -1
        // When we will go right we will do +1
        if (map.get(distance) == null) {
            // Create a fresh ArrayList
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(root.data);
            map.put(distance, arr);
        } else {
            // Add to the existing key...
            map.get(distance).add(root.data);
        }
        diagonalView(root.left, distance + 1, map);
        diagonalView(root.right, distance, map);

    }

    boolean isChildrenSum(BinaryTreeNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        int sum = 0;
        if (root.left != null) {
            sum += root.left.data;
        }
        if (root.right != null) {
            sum += root.right.data;
        }
        return root.data == sum && isChildrenSum(root.left) && isChildrenSum(root.right);
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
                    // obt.printLeftView(root, 1);
                    // obt.printRightView(root, 1);
                    // obt.printVerticalOrder(root);
                    break;
                case 3:
                    System.out.println(OperationsOnBinaryTree.heightR(root));
                    break;
                case 4:
                    System.exit(0);
                    ;

            }

        }
        // I.close();

    }
}
