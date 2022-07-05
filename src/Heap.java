import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> items = new ArrayList<>();;


    public void insert(int value) {
        items.add(value);
        int index = items.indexOf(value);
        int parentIndex = getParentIndex(index);
        while (parentIndex > -1 && items.get(index) > items.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();
        int removedItem = items.get(0);
        swap(0, items.size() - 1);
        items.remove(items.size() - 1);
        bubbleDown();
        return removedItem;
    }

    private void bubbleDown(){
        int index = 0;
        while (index <= items.size() && !isValidParent(index)) {
            int largerChild = largerChildIndex(index);
            swap(index, largerChild);
            index = largerChild;
        }
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return getLeftChildIndex(index);

        return leftChild(index) > rightChild(index) ? getLeftChildIndex(index) : getRightChildIndex(index);
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }


    private int leftChild(int index) {
        return items.get(getLeftChildIndex(index));
    }

    private int rightChild(int index) {
        return items.get(getRightChildIndex(index));
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        var isValid = items.get(index) > leftChild(index);

        if (hasRightChild(index))
            isValid &= items.get(index) >= rightChild(index);

        return isValid;
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < items.size();
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < items.size();
    }

    private int getParentIndex(int index) {
        if (index == 0) return -1;
        int parentIndex = (int) Math.floor((index - 1) / 2);
        return parentIndex;
    }

    private void swap(int firstIndex, int secondIndex) {
        int firstValue = items.get(firstIndex);
        int secondValue = items.get(secondIndex);
        items.set(firstIndex, secondValue);
        items.set(secondIndex, firstValue);
    }

    public void print() {
        System.out.println(items);
    }

    public static boolean isMaxHeap(int[] items){
        for (int i = items.length / 2 - 1; i >= 0; i--) {
            if (!isValidParent(items, i))
                return false;
        }
        return true;
    }

    public static boolean isValidParent(int[] items, int i){
        int leftChildIndex = i * 2 + 1;
        if (leftChildIndex >= items.length)
            return true;

        var isValid = items[i] > items[leftChildIndex];

        int rightChildIndex= i * 2 + 2;
        if (leftChildIndex < items.length)
            isValid &= items[i] >= items[i];

        return isValid;
    }
}
