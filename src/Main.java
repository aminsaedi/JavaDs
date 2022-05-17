import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();


        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addFirst(0);

        System.out.println(myList.indexOf(2));

        myList.print();
    }
}