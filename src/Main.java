import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();


        myList.addFirst(30);
        myList.addFirst(20);
        myList.addFirst(10);

        myList.reverse();

        myList.print();
    }
}