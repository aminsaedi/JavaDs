import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        public char value;
        private HashMap<Character, Node> children = new HashMap<>();
        public boolean isEndOfWord = false;

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public void removeChild(char ch) {
//            System.out.println("I'm " + value + " And now removing my child => " + ch);
            children.remove(ch);
        }

        @Override
        public String toString() {
            return "Value=" + this.value;
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        char[] chars = word.toCharArray();

        var current = root;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            ch = Character.toLowerCase(ch);
            if (!current.hasChild(ch)) current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null) return false;

        char[] chars = word.toCharArray();

        var current = root;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            ch = Character.toLowerCase(ch);
            if (!current.hasChild(ch)) return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        System.out.println(root.value + " => " + root.isEndOfWord);
        for (Node node : root.getChildren()) {
            traverse(node);
        }
    }

    public void remove(String word) {
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {

        if (index == word.length()) {
            System.out.println("End of word");
            root.isEndOfWord = false;
            return;
        }

        char ch = word.charAt(index);
        var child = root.getChild(ch);


        if (child == null) return;

        System.out.println("Let's look for => " + word.charAt(index));
        remove(child, word, index + 1);

        System.out.println("I'm " + child.value);
        if (child.getChildren().length == 0 && !child.isEndOfWord) {
            root.removeChild(word.charAt(index));
        }
    }

    private String removeLastChar(String s) {
//returns the string after removing the last character
        return s.substring(0, s.length() - 1);
    }

    public List<String> getSuggestions(String word) {
        var lastNode = getLastNodeOf(word);
        System.out.println("lastNode=" + lastNode);
        List<String> list = new ArrayList<>();
        getSuggestions(lastNode, word, list);
        return list;
    }

    private Node getLastNodeOf(String prefix) {
        if (prefix == null)
            return null;

        var current = root;
        for (char ch : prefix.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }

    private void getSuggestions(Node root, String word, List<String> list) {
        if (root == null)
            return;

        if (root.isEndOfWord)
            list.add(word);

        for (Node child : root.getChildren()) {
            getSuggestions(child, word + child.value, list);
        }
    }

    public boolean containsRecursive(String word) {
        return containsRecursive(root, word, 0);
    }

    private boolean containsRecursive(Node root, String word, int index) {
        if (index == word.length()) {
            return root.isEndOfWord;
        }
        return root.hasChild(word.charAt(index)) && containsRecursive(root.getChild(word.charAt(index)), word, index + 1);
    }

}
