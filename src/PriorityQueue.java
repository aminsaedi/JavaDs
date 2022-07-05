import java.util.Arrays;

public class PriorityQueue {

    int[] arr;
    int count = 0;

    public PriorityQueue(int cap) {
        arr = new int[cap];
    }

    public void enqueue(int value) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (arr[i] > value)
                arr[i + 1] = arr[i];
            else
                break;
        }
        arr[i + 1] = value;
        count++;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
