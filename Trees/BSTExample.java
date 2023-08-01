class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;
    int height;

    BSTNode(int data) {
        this.data = data;
    }

}

class BSTOperation {
    BSTNode root;

    BSTNode insertInBST(BSTNode currentNode, int data) {
        // if root is not present
        // Here this if statement will create the new node
        if (root == null) {
            root = new BSTNode(data);
            return root;
        }

        if (data < currentNode.data)
            currentNode.left = insertInBST(currentNode.left, data);
        else if (data < currentNode.data)
            currentNode.right = insertInBST(currentNode.right, data);
        return currentNode;
    }
}

public class BSTExample {
    public static void main(String[] args) {

    }
}
