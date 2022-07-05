import javax.swing.plaf.IconUIResource;

public class Tree {
    private class Node {
        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        private int value;

        private Node rightChild;
        private Node leftChild;


    }

    private Node root;

    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }

    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else return true;
        }
        return false;
    }


    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
//      Base Condition
        if (root == null) return;

        System.out.println(root.value);

        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
//      Base Condition
        if (root == null) return;

        traverseInOrder(root.leftChild);

        System.out.println(root.value);

        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
//      Base Condition
        if (root == null) return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);

        System.out.println(root.value);

    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) return -1;

        if (root.leftChild == null && root.rightChild == null) return 0;

        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        if (root.leftChild == null && root.rightChild == null) return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public int getMostLeft() {
        return getMostLeft(root);
    }

    private int getMostLeft(Node root) {
        if (root.leftChild == null) return root.value;
        return getMostLeft(root.leftChild);
    }

    public int getMostRight() {
        return getMostRight(root);
    }

    private int getMostRight(Node root) {
        if (root.rightChild == null)
            return root.value;
        return getMostRight(root.rightChild);
    }


    public void equals(Tree secondTree) {
        System.out.println(equals(secondTree.root, root));
        ;
    }

    private boolean equals(Node node1, Node node2) {

        if (node1 == null && node2 == null) return true;

        if (node1 != null && node2 != null)
            return node1.value == node2.value
                    && equals(node1.leftChild, node2.leftChild)
                    && equals(node1.rightChild, node2.rightChild);
        return false;
    }


    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    private boolean isBST(Node node, int min, int max) {
        if (node == null)
            return true;

        boolean one = node.value > min && node.value < max;

        boolean two = isBST(node.leftChild, min, node.value - 1);

        boolean three = isBST(node.rightChild, node.value + 1, max);

        return one && two && three;
    }

    public void distance(int distance) {
        distance(root, distance);
    }

    private void distance(Node node, int d) {
//        System.out.println("D="+d);
        if (node == null) return;

        System.out.println("VALUE=" + node.value + " D=" + d);

        if (d == 0) {
            System.out.println(node.value);
//            return;
        }

        int newD = d - 1;

        distance(node.leftChild, newD);
        distance(node.rightChild, newD);

    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(Node node) {
        if (node == null) return 0;
        int length = 0;

        if (node != null) length++;

        length += getSize(node.leftChild);
        length += getSize(node.rightChild);

        return length;
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node node) {
        if (node == null) return 0;

        int sum = 0;

        if (node.leftChild == null && node.rightChild == null) sum++;

        sum += countLeaves(node.leftChild);
        sum += countLeaves(node.rightChild);

        return sum;

    }

    public int max() {
        return max(root);
    }

    private int max(Node node) {
        int max = Integer.MIN_VALUE;

        if (node == null) return max;

        if (node.value > max) max = node.value;

        if (max(node.leftChild) > max)
            max = max(node.leftChild);
        if (max(node.rightChild) > max)
            max = max(node.rightChild);

        return max;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null) return false;
        return node.value == value || contains(node.leftChild, value) || contains(node.rightChild, value);
    }

    public boolean areSiblings(int value1, int value2) {
        return areSiblings(root, value1, value2);
    }

    private boolean areSiblings(Node node, int value1, int value2){
        if (node == null) return false;

        return (node.leftChild.value == value1 && node.rightChild.value == value2)
                || (node.leftChild.value == value2 && node.rightChild.value == value1)
                || areSiblings(node.leftChild, value1, value2)
                || areSiblings(node.rightChild, value1, value2);

    }

}
