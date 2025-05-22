package sreproject;

import java.awt.*;

public class GroundRenderer implements Renderable {
    private int width, height;

    public GroundRenderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(Graphics g) {
        // Ground base
        g.setColor(new Color(205, 133, 63)); // SaddleBrown
        g.fillRect(0, height - 120, width, 100);

        // Grass layer on top
        g.setColor(new Color(50, 205, 50)); // LimeGreen
        g.fillRect(0, height - 120 + 100, width, 20);
    }
}