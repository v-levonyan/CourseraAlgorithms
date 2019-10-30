package LinesAndShapes;

import java.awt.*;

public class Edge {
    private Vertex v1;
    private Vertex v2;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

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
        g.drawLine(x1, y1, x2, y2);
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public Edge withCoordinates(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        return this;
    }

    public void draw(Graphics g) {
        int x1 = Double.valueOf(v1.getX() + this.x1).intValue();
        int y1 = Double.valueOf(v1.getY() + this.y1).intValue();
        int x2 = Double.valueOf(v2.getX() + this.x2).intValue();
        int y2 = Double.valueOf(v2.getY() + this.y2).intValue();
        draw(g,x1, y1, x2, y2);
    }

    public void draw(Graphics g, Color color) {
        int x1 = Double.valueOf(v1.getX() + this.x1).intValue();
        int y1 = Double.valueOf(v1.getY() + this.y1).intValue();
        int x2 = Double.valueOf(v2.getX() + this.x2).intValue();
        int y2 = Double.valueOf(v2.getY() + this.y2).intValue();
        g.setColor(color);
        draw(g,x1, y1, x2, y2);
    }

    public boolean contains(int v) {
        return this.v1.getNumber() == v || this.v2.getNumber() == v;
    }
}
