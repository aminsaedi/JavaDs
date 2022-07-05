import java.util.*;

public class Main {


    public static  void main(String[] args) {
        var minHeap = new MinHeap();

        minHeap.insert(1, "Amin");
        minHeap.insert(3, "Saedi");
        minHeap.insert(5, "Kambiz");
        minHeap.insert(2, "Fesharaki");

        minHeap.print();
    }
}