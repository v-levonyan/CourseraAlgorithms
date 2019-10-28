package LinesAndShapes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.*;
public class LinesAndShapes extends JPanel implements ActionListener {

    private static final double RAD = 50;
    private static Vertex[] vertices;
    private static Graph graph;
    private final Timer timer;
    private int vertexNum;

    public static void main(String[] args) {
        //let's setup the frame so we can keep adding to our program
        JFrame f = new JFrame("Twilight Zone");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new LinesAndShapes());
        f.setSize(1000, 1000);
        f.setLocation(550, 25);
        f.setVisible(true);
        double startX = 50;
        double startY = 50;

        vertices = new Vertex[7];
        vertices[0] = new Vertex(startX,startY, 50, "0");
        vertices[1] = new Vertex(startX,startY + 500, 50, "5");
        vertices[2] = new Vertex(startX + 400,startY + 400, 50, "4");
        vertices[3] = new Vertex(startX + 500,startY + 100, 50, "6");
        vertices[4] = new Vertex(startX + 200,startY + 350, 50, "3");
        vertices[5] = new Vertex(startX + 150,startY + 100, 50, "1");
        vertices[6] = new Vertex(startX + 325,startY + 100, 50, "2");

        graph = new Graph(vertices);
        graph.addEdge(vertices[0], vertices[1]);
        graph.addEdge(vertices[0], vertices[3]);
        graph.addEdge(vertices[0], vertices[5]);
        graph.addEdge(vertices[0], vertices[6]);
        graph.addEdge(vertices[2], vertices[3]);
        graph.addEdge(vertices[2], vertices[4]);
        graph.addEdge(vertices[2], vertices[1]);
        graph.addEdge(vertices[1], vertices[4]);
    }


    public LinesAndShapes() {
        timer = new Timer(20000, this);
        timer.setInitialDelay(190);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.paint(g);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, vertices[0]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

