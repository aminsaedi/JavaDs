import java.util.Arrays;

public class ArrayQueue {

    private int[] arr;
    private int front = 0;
    private int rear = 0;

    private int count = 0;

    public ArrayQueue(int size) {
        arr = new int[size];
    }

    public void enqueue(int value) {
        if (isFull()) throw new StackOverflowError();
        arr[rear] = value;

        rear = (rear + 1) % arr.length;
        count++;
    }

    public int dequeue() {
        var temp = arr[front];
        arr[front++] = 0;
        count--;
        return temp;
    }

    public int peek() {
        return arr[front];
    }

    public boolean isFull() {
        return count == arr.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
