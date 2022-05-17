public class LinkedList {

    private Node first;
    private Node last;

    public void addFirst(int value) {
        if (first == null) {
            first = new Node(value, null);
            if (last == null)
                last = first;
        } else {
            first = new Node(value, first);
        }
    }

    public void addLast(int value) {

        Node l = last;
        last = new Node(value, null);

        if (l == null)
            first = last;
        else
            l.next = last;

    }

    public void deleteFirst() {
        first = first.next;
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
            if (item.value == value) break;
            item = item.next;
            counter++;
        }
        return counter;
    }

    public void print() {
        Node item = first;
        if (first == null) System.out.println("Nothing to print");
        do {
            System.out.println(item.value);
            item = item.next;
        } while (item != null);
    }

//    addFirst Done
//    addLast Done
//    deleteFirst Done
//    deleteLast Done
//    contains Done
//    indexOf Done
}
