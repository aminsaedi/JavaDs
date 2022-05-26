import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);
        myList.addLast(5);
        myList.addLast(6);

        myList.printMiddle();

//        System.out.println(myList.getKthNodeFormTheEnd(4).value);
    }
}