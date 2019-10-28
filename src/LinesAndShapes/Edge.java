package LinesAndShapes;

import java.awt.*;

public class Edge {
    private Vertex v1;
    private Vertex v2;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public void draw(Graphics g, double castX1, double castY1, double castX2, double castY2) {
        int x1 = Double.valueOf(v1.getX() + castX1).intValue();
        int y1 = Double.valueOf(v1.getY() + castY1).intValue();
        int x2 = Double.valueOf(v2.getX() + castX2).intValue();
        int y2 = Double.valueOf(v2.getY() + castY2).intValue();
        draw(g,x1, y1, x2, y2);
    }

    private void draw(Graphics g, int x1, int y1, int x2, int y2) {
        String hexColor = new String("0x45e5B");
        //custom color
        g.setColor(Color.decode(hexColor));
        //draw a line (starting x,y; ending x,y)
        g.drawLine(x1, y1, x2, y2);
    }
}
