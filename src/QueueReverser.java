import java.util.Arrays;
import java.util.Queue;

public class QueueReverser {
    public void reverse(Queue<Integer> input, int k) {
//        [10, 20, 30, 40, 50]

//        [10, 20, 30]

//        3-
        int initialSize = input.size();
        var stack = new Stack();
        for (int i = 0; i < k; i++) {
            stack.push(input.remove());
        }
        while (!stack.isEmpty()){
            input.add(stack.pop());
        }
        for (int i = 0; i < initialSize - 3; i++) {
            input.add(input.remove());
        }

        System.out.println(Arrays.toString(input.toArray() ));

    }
}
