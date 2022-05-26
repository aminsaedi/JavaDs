public class LinkedList {

    private Node first;
    private Node last;
    private int count = 0;

    public void addFirst(int value) {
        if (first == null) {
            first = new Node(value, null);
                last = first;
        } else {
            first = new Node(value, first);
        }
        count++;
    }

    public void addLast(int value) {

        var node = new Node(value, null);

        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        count++;
    }

    public void deleteFirst() {
        var second = first.next;
        first.next = null;
        first = second;
        count--;
    }

    public void deleteLast() {
        Node item = first;
        while (item != null) {
            if (item.next == last) break;
            item = item.next;
        }
        item.next = null;
        last = item;

        count--;
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

        System.out.println("Size=" + count);
    }

    private Node at(int index){
        Node item = first;
        int count = 0;
        while (item != null){
            if (index == count) return item;
            item = item.next;
            count++;
        }
        return null;
    }

    public void reverse()
    {
        Node c = first.next;
        Node p = first;
        while (c != null) {
            Node n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        last = first;
        last.next = null;
        first = p;
//        first = p;
    }

    public Node getKthNodeFormTheEnd(int k) {
//        [1, 2, 3, 4 ,5]
//         *     *
        Node p1 = first;
        Node p2 = first;

        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    private Node getPrev(Node node) {
        Node item = first;

        while (item != null) {
            if (item.next == node) return item;
            item = item.next;
        }
        return  null;
    }

    public void printMiddle(){
//        [1, 2, 3, 4, 5, 6] => i = 0, 1 always zoj = i
//               *  *
//        [1, 2, 3, 4, 5] always fard = i
//             *  *
        Node p1 = first;
        Node p2 = last;

        while (true){
            p1 = p1.next;
            p2 = getPrev(p2);
            if (p1 == p2 || p1.next == p2) break;
        }
        System.out.println(p1.value);
        System.out.println(p2.value);
    }

//    addFirst Done
//    addLast Done
//    deleteFirst Done
//    deleteLast Done
//    contains Done
//    indexOf Done
}
