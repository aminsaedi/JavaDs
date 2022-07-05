import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListQueue {

    private LinkedList list = new LinkedList<Integer>();

    public void enqueue(int value) {
        list.add(value);
    }

    public int dequeue(){
        return (int)  list.removeFirst();
    }

    @Override
    public  String toString(){
        return Arrays.toString(list.toArray());
    }


}
