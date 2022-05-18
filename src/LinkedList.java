public class LinkedList {

    private Node first;
    private Node last;

    private boolean isEmpty() {
        return first == null;
    }

    public void addFirst(int value) {
        if (isEmpty()) {
            first = new Node(value, null, null);
            last = first;
            last.prev = first;

        } else {
            var newNode = new Node(value, first, null);
            first.prev = newNode;
            first = newNode;
        }
    }

//    public void addLast(int value) {
//
//        var node = new Node(value, null);
//
//        if (isEmpty()) {
//            first = last = node;
//        } else {
//            last.next = node;
//            last = node;
//        }
//    }

    public void deleteFirst() {
        var second = first.next;
        first.next = null;
        first = second;
    }

    public void deleteLast() {
        Node item = first;
        while (item != null) {
            if (item.next == last) break;
            item = item.next;
        }
        item.next = null;
        last = item;
    }

    public boolean contains(int value) {
        Node item = first;
        while (item != null) {
            if (item.value == value) return true;
            item = item.next;
        }
        return false;
    }

    public int indexOf(int value) {
        int counter = 0;
        Node item = first;

        while (item != null) {
            if (item.value == value) return counter;
            item = item.next;
            counter++;
        }
        return -1;
    }

    public void print() {
        Node item = first;
        if (first == null) System.out.println("Nothing to print");
        do {
            System.out.println(item.value);
            item = item.next;
        } while (item != null);
    }

    public void reverse() {
        var newList = new LinkedList();

        var item = first;

        while (item != null ){
            newList.addFirst(item.value);
            item = item.next;
        }

        newList.print();

        first = newList.first;
        last = newList.last;
    }

//    addFirst Done
//    addLast Done
//    deleteFirst Done
//    deleteLast Done
//    contains Done
//    indexOf Done
//    reverse
}
