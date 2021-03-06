package LinesAndShapes;

import javax.swing.*;

import static LinesAndShapes.Vertex.RAD;

public class SwingPaintDemo3 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());

        JFrame f = new JFrame("Depth first search");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 1000);
        f.setLocation(550, 25);
        f.setVisible(true);
        double startX = 50;
        double startY = 50;

        Vertex[] vertices = new Vertex[7];
        vertices[0] = new Vertex(startX,startY, 50, 0);
        vertices[1] = new Vertex(startX,startY + 500, 50, 5);
        vertices[2] = new Vertex(startX + 400,startY + 400, 50, 4);
        vertices[3] = new Vertex(startX + 500,startY + 100, 50, 6);
        vertices[4] = new Vertex(startX + 200,startY + 350, 50, 3);
        vertices[5] = new Vertex(startX + 150,startY + 100, 50, 1);
        vertices[6] = new Vertex(startX + 325,startY + 100, 50, 2);

        Graph graph = new Graph(vertices);

        graph.addEdge(new Edge(vertices[0], vertices[1]).withCoordinates(RAD/2, RAD, RAD/2, 0));
        graph.addEdge(new Edge(vertices[1], vertices[2]).withCoordinates(RAD, RAD/2, 0, RAD/2));
        graph.addEdge(new Edge(vertices[2], vertices[3]).withCoordinates(RAD/2, 0, RAD/2, RAD));
        graph.addEdge(new Edge(vertices[0], vertices[3]).withCoordinates(RAD, RAD/2, 0, RAD/2));
        graph.addEdge(new Edge(vertices[0], vertices[6]).withCoordinates(RAD, RAD/2, 0, RAD/2));
        graph.addEdge(new Edge(vertices[0], vertices[5]).withCoordinates(RAD, RAD/2, 0, RAD/2));
        graph.addEdge(new Edge(vertices[1], vertices[4]).withCoordinates(RAD, RAD/2, 0, RAD/2));
        graph.addEdge(new Edge(vertices[4], vertices[2]).withCoordinates(RAD, RAD/2, 0, RAD/2));

        f.add(new DepthFirstSearch(graph, vertices[0]));
    }
}
