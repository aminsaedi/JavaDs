import java.util.LinkedList;

public class HashTable {
    private class Entry {
        public int key;
        public String value;

        public Entry(int k, String v) {
            key = k;
            value = v;
        }

    }

    private LinkedList<Entry>[] items = new LinkedList[100];

    public HashTable() {

    }

    public void put(int k, String v) {
        int hash = hash(k);
        System.out.println("Putting with hash " + hash);
        if (items[hash] == null) {
            items[hash] = new LinkedList<Entry>();
            items[hash].addLast(new Entry(k, v));
        } else {
//            if there is an item with the same key ? replace it : add new item at the end of the linked list
            for (int i = 0; i < items[hash].size(); i++) {
                var item = items[hash].get(i);
                if (item.key == k) {
                    System.out.println("++");
                    item.value = v;
//                    items[hash].set(i, item);
                    return;
                }

            }
            items[hash].addLast(new Entry(k, v));
        }

    }

    public String get(int k) {
        int hash = hash(k);
        for (int i = 0; i < items[hash].size(); i++) {
            var e = items[hash].get(i);
            if (e.key == k) return e.value;
        }
        return "_";
    }

    public void remove(int k) {
        int index = hash(k);
        var bucket = items[index];
        for (int i = 0; i < bucket.size(); i++) {
            var entry = bucket.get(i);
            if (entry.key == k) bucket.remove(i);
        }
    }

    private int hash(int k) {
        return k % items.length;
    }

}
