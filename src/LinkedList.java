public class LinkedList {

    private Node first;
    private Node last;
    private int count = 0;

    public LinkedList(){
        var n10 = new Node(10, null);
        var n20 = new Node(20, null);
        var n30 = new Node(30, null);
        var n40 = new Node(40, null);
        var n50 = new Node(50, null);

        first = n10;
        first.next = n20;
        first.next.next = n30;
        first.next.next.next = n40;
        first.next.next.next.next = n50;
//        first.next.next.next.next.next =  first.next.next;


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
//               *
//                     *
//        [1, 2, 3, 4, 5] always fard = i
//               *
//                      *
        Node p1 = first;
        Node p2 = first;

        while (p2 != last && p2.next != last){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        System.out.println(p1.value);
        if (p2.next != null){
            System.out.println(p1.next.value);
        }

    }

    public boolean hasLoop(){
        Node p1= first;
        Node p2 = first;

        while (p2 != null && p2.next != null){
            if (p2.next == p1) return  true;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }

//    addFirst Done
//    addLast Done
//    deleteFirst Done
//    deleteLast Done
//    contains Done
//    indexOf Done
}
