package LinesAndShapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Vertex {
    public static final int RAD = 50;
    private double x;
    private double y;
    private double rad;
    private int number;

    public Vertex(double x, double y, double rad, int number) {
        this.x = x;
        this.y = y;
        this.rad = rad;
        this.number = number;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRad() {
        return rad;
    }

    public int getNumber() {
        return number;
    }

    public void drawVertex(Graphics2D g2) {
        drawVertex(g2,getX(), getY(), getRad(), getRad(), getNumber());
    }

    private void drawVertex(Graphics2D g2, double startX, double startY, double width, double height, int vertexNum) {
        Ellipse2D.Double circle =
                new Ellipse2D.Double(startX, startY, width, height);
        g2.draw(circle);
        g2.drawString(String.valueOf(vertexNum), new Double(circle.getCenterX()).intValue(), new Double(circle.getCenterY()).intValue());
    }


    public void fillVertex(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circle =
                new Ellipse2D.Double(x, y, rad, rad);
        g2.fill(circle);
    }


    public void fillVertex(Graphics g, Color color) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circle =
                new Ellipse2D.Double(x, y, rad, rad);
        g2.setColor(color);
        g2.fill(circle);
    }
}
