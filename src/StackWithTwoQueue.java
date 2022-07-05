import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueue {
    private Queue q1 = new ArrayDeque();
    private Queue q2 = new ArrayDeque();

    public void push(int value){
//        [10, 20, 30, 40, 50]
//        [10, 20, 30, 40]
        q1.add(value);
    }

    public int pop(){
        int initialSize = q1.size();
        for (int i = 0; i < initialSize - 1; i++) {
            q2.add(q1.remove());
        }
        int item = (int) q1.remove();
//        Now q1 should be empty
        while (!q2.isEmpty())
            q1.add(q2.remove());
        return  item;
    }

    public int peek(){
        int initialSize = q1.size();
        for (int i = 0; i < initialSize - 1; i++) {
            q2.add(q1.remove());
        }
        int item = (int) q1.remove();
//        Now q1 should be empty
        while (!q2.isEmpty())
            q1.add(q2.remove());
        q1.add(item);
        return  item;
    }

    public int size(){
        return q1.size();
    }

    public boolean isEmpty(){
        return q1.isEmpty();
    }
}
