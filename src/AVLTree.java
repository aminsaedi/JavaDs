public class AVLTree {
    private class Node {
        public Node leftChild;
        public Node rightChild;
        public int value;
        public int height;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "V=" + this.value + "H=" + this.height;
        }
    }


    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null)
            return new Node(value);

        if (value > node.value)
            node.rightChild = insert(node.rightChild, value);
        else node.leftChild = insert(node.leftChild, value);

        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;

        node = balance(node);

        return node;
    }

    private Node balance(Node node) {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0)
                node.leftChild = rotateLeft(node.leftChild);
            node = rotateRight(node);
        }
        if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0)
                node.rightChild = rotateRight(node.rightChild);
            node = rotateLeft(node);
        }
        return node;
    }

    private Node rotateLeft(Node root) {
        Node newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        newRoot.height = Math.max(height(newRoot.leftChild), height(newRoot.rightChild)) + 1;
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
        return newRoot;
    }

    private Node rotateRight(Node root) {
        Node newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        newRoot.height = Math.max(height(newRoot.leftChild), height(newRoot.rightChild)) + 1;
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
        return newRoot;
    }

    private int height(Node node) {
        return (node == null) ? -1 : node.height;
    }

    private boolean isRightHeavy(Node node) {
        return balanceFactor(node) < -1;
    }

    private boolean isLeftHeavy(Node node) {
        return balanceFactor(node) > 1;
    }

    private int balanceFactor(Node node) {
        return node == null ? 0 : height(node.leftChild) - height(node.rightChild);
    }
}
