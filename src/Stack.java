import java.util.Arrays;
public class Stack {

    private int[] arr;
    private int lastIndex = 0;

    public Stack(){
        arr = new int[1];
    }

    public void push(int value) {
        if (lastIndex == arr.length) {
            int[] temp = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
       arr[lastIndex++] = value;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();
        return arr[lastIndex-- - 1];
    }

    public int peek() {
        return arr[lastIndex - 1];
    }

    public boolean isEmpty(){
        return lastIndex == 0;
    }


    @Override
    public String toString(){
        var content = Arrays.copyOfRange(arr, 0, lastIndex);
        return  Arrays.toString(content);
    }
}
