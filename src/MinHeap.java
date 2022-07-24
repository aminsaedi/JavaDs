import java.util.ArrayList;
import java.util.HashMap;

public class MinHeap {

    private class Node {
        public int key;
        public String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return this.key + "=>" + this.value;
        }
    }

    private ArrayList<Node> items = new ArrayList<>();

    public void insert(int key, String value) {
        var node = new Node(key, value);
        items.add(node);
        int index = items.indexOf(node);
        int parentIndex = getParentIndex(index);
        while (parentIndex > -1 && items.get(index).key < items.get(parentIndex).key) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    public String remove(){
        var removedItem = items.get(0);
        swap(0, items.size() - 1);
        items.remove(items.size() - 1);
        bubbleDown();
        return removedItem.toString();

    }

    public void print() {
        System.out.println(items);
    }

    private void bubbleDown(){
        int index = 0;
        while (index <= items.size() && !isValidParent(index)){
            int smallerItemIndex = smallerChildIndex(index);
            swap(index, smallerItemIndex);
            index = smallerItemIndex;
        }
    }

    private int smallerChildIndex(int index){
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);
        return leftChild(index).key < rightChild(index).key ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index){
        if (!hasLeftChild(index))
            return true;
        var isValid = items.get(index).key < leftChild(index).key;

        if (hasRightChild(index))
            isValid &= items.get(index).key < rightChild(index).key;

        return isValid;
    }

    private int leftChildIndex(int index){
        return index * 2 + 1;
    }
    private boolean hasLeftChild(int index){
        return leftChildIndex(index) < items.size();
    }
    private Node leftChild(int index){
        return items.get(leftChildIndex(index));
    }

    private int rightChildIndex(int index){
        return index * 2 + 2;
    }
    private boolean hasRightChild(int index){
        return rightChildIndex(index) < items.size();
    }
    private Node rightChild(int index){
        return items.get(rightChildIndex(index));
    }

    private void swap(int indexOne, int indexTwo) {
        var temp = items.get(indexOne);
        items.set(indexOne, items.get(indexTwo));
        items.set(indexTwo, temp);
    }

    private int getParentIndex(int index) {
        if (index == 0) return -1;
        int parentIndex = (int) Math.floor((index - 1) / 2);
        return parentIndex;
    }
}
