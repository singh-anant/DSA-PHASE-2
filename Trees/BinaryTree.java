import java.util.Scanner;

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

    void postOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);

    }

    void inOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
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
                    obt.print(root);
                    break;
                case 3:
                    System.exit(0);
                    ;

            }

        }
        // I.close();

    }
}
