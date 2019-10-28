package LinesAndShapes;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

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
        vertices[0] = new Vertex(startX,startY, 50, "0");
        vertices[1] = new Vertex(startX,startY + 500, 50, "5");
        vertices[2] = new Vertex(startX + 400,startY + 400, 50, "4");
        vertices[3] = new Vertex(startX + 500,startY + 100, 50, "6");
        vertices[4] = new Vertex(startX + 200,startY + 350, 50, "3");
        vertices[5] = new Vertex(startX + 150,startY + 100, 50, "1");
        vertices[6] = new Vertex(startX + 325,startY + 100, 50, "2");

        Graph graph = new Graph(vertices);
        graph.addEdge(vertices[0], vertices[1]);
        graph.addEdge(vertices[0], vertices[3]);
        graph.addEdge(vertices[0], vertices[5]);
        graph.addEdge(vertices[0], vertices[6]);
        graph.addEdge(vertices[2], vertices[3]);
        graph.addEdge(vertices[2], vertices[4]);
        graph.addEdge(vertices[2], vertices[1]);
        graph.addEdge(vertices[1], vertices[4]);



        f.add(new DepthFirstSearch(graph, vertices[0]));
    }
}

class MyPanel extends JPanel {

    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;

    public MyPanel() {

        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });

    }

    private void moveSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX!=x) || (squareY!=y)) {
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
            squareX=x;
            squareY=y;
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
        }
    }


    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("This is my custom Panel!",10,20);
        g.setColor(Color.RED);
        g.fillRect(squareX,squareY,squareW,squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX,squareY,squareW,squareH);
    }
}
