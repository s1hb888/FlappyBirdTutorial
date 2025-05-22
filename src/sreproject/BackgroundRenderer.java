package sreproject;

import java.awt.*;
import java.awt.geom.Point2D;

public class BackgroundRenderer implements Renderable {
    private int width, height;

    public BackgroundRenderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(Graphics g) {
        // Draw gradient background
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(
                new Point2D.Float(0, 0),
                new Color(70, 130, 180), // Steel blue
                new Point2D.Float(0, height),
                new Color(135, 206, 250)); // Light sky blue
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);

        // Optional: Draw sun
        g.setColor(Color.YELLOW);
        g.fillOval(width - 150, 100, 80, 80);
    }
}