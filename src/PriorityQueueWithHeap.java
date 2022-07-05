public class PriorityQueueWithHeap {
    private Heap head = new Heap();

    public void enqueue(int value) {
        head.insert(value);
    }

    public int dequeue() {
        return head.remove();
    }

    public boolean isEmpty() {
        return head.isEmpty();
    }
}
