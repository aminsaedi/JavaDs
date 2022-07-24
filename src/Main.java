import java.util.*;

public class Main {


    public static void main(String[] args) {
        var graph = new Graph();

        graph.addNode("Amin");
        graph.addNode("Ho3ein");
        graph.addNode("Mamad");
        graph.addNode("Amir");
        graph.addNode("Ali");


        graph.addEdge("Amin", "Amir");
        graph.addEdge("Amin", "Ho3in");
        graph.addEdge("Amin", "Mamad");
        graph.addEdge("Amin", "Ali");

        graph.removeNode("Ali");
        graph.print();
    }
}