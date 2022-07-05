import java.util.Arrays;
import java.util.Stack;

public class StackQueue {
    private Stack stack1 = new Stack<>();
    private Stack stack2 = new Stack<>();


//    [10, 20, 30, 40, 50]
//    [10, 20, 30, 40, 50]

    public void enqueue(int value) {
        stack1.push(value);
    }

    public int dequeue() {
        int size = stack1.size();
        for (int i = 0; i < size - 1; i++) {
            stack2.push(stack1.pop());
        }
        int item = (int) stack1.pop();
        size = stack2.size();
        for (int i = 0; i < size; i++) {
            stack1.push(stack2.pop());
        }
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack1.toArray()) + "\n" + Arrays.toString(stack2.toArray());
    }
}
