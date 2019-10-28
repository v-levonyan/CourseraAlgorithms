public class Main {

    public static void main(String[] args) {

        Graph G = createGraph(13);
        int s = 2;

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(G, s);

        for (int p : depthFirstSearch.pathTo(3)) {
            System.out.println(p);
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

        graph.addEdge(7, 8);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);


        return graph;
    }
}
