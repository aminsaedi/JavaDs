import java.util.*;
import java.util.LinkedList;

public class Graph {
    private class Node {
        public String value;

        public Node(String value) {
            this.value = value;
        }

        @Override
        public String toString(){
            return "=>" + this.value;
        }
    }

    Map<String, List<Node>> adjacencyList = new HashMap<>();
    Map<String, Node> nodes = new HashMap<>();


    public void addNode(String value){
        nodes.putIfAbsent(value, new Node(value));
        adjacencyList.putIfAbsent(value, new ArrayList<Node>());
    }

    public void removeNode(String value) {
        for (var item: adjacencyList.keySet()){
            var list = adjacencyList.get(item);
            for (var j: list) {
                if (j.value.equals(value)){
                    var index = list.indexOf(j);
                    list.remove(index);
                }
            }
        }

    }

    public void addEdge(String from, String to) {
        adjacencyList.get(from).add(new Node(to));
    }

    public void removeEdge(String from, String to){
        var row = adjacencyList.get(from);
        for (var node :
                row.toArray(new Node[row.size()])) {
            if (node.value.equals(to)){
                var index= row.indexOf(node);
                row.remove(index);
            }
        }
    }

    public void print(){
        System.out.println(adjacencyList);
    }
}
