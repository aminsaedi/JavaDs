import java.util.Arrays;

public class TwoStack {

    private int[] arr;

    private int topL = 0;
    private int topR = 0;

    public TwoStack(int cap) {
        arr = new int[cap];
        topL = -1;
        topR = cap;
    }

    public void push1(int value){
        if (isFull1()) throw new IllegalStateException();
        arr[++topL] = value;
    }

    public void push2(int value) {
        if (isFull2()) throw new IllegalStateException();
        arr[--topR] = value;
    }

    public int peek1(){
        return arr[topL];
    }

    public int peek2(){
        return arr[topR];
    }

    public int pop1(){
        return arr[topL--];
    }

    public int pop2(){
        return arr[topR++];
    }

    private boolean isEmpty1(){
        return  topL == -1;
    }

    private boolean isFull1() {
        return topL + 1 == topR;
    }

    private boolean isEmpty2(){
        return topR == arr.length;
    }

    private boolean isFull2(){
        return topL + 1 == topR;
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
}
