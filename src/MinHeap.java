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

    public void remove(){
        swap();
    }

    public void print() {
        System.out.println(items);
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
