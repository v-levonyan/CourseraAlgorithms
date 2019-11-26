import DataStructures.DiGraph;
import DataStructures.Graph;

import algorithms.DirectedCycle;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        DiGraph G = createDiGraph(8);

        DirectedCycle directedCycle = new DirectedCycle(G);

        System.out.println("Has cycle: " + directedCycle.hasCycle());

        for (Stack<Integer> cycle : directedCycle.cycles()) {
            System.out.println("cycle: " + cycle);
        }

    }

    private static Graph createGraph(int v) {

        Graph graph = new Graph(v);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(6, 4);
        graph.addEdge(3, 1);

        return graph;
    }

    private static DiGraph createDiGraph(int v) {

        DiGraph graph = new DiGraph(v);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 7);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
        graph.addEdge(7, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 7);
        graph.addEdge(7, 1);

        return graph;
    }
}
