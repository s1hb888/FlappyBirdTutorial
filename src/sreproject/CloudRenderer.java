package sreproject;

import java.awt.*;
import java.util.Random;

public class CloudRenderer implements Renderable {
    private static final int CLOUD_COUNT = 5;
    private int[] xPositions = new int[CLOUD_COUNT];
    private int[] yPositions = new int[CLOUD_COUNT];
    private Random rand = new Random();

    public CloudRenderer(int width, int height) {
        for (int i = 0; i < CLOUD_COUNT; i++) {
            xPositions[i] = rand.nextInt(width);
            yPositions[i] = rand.nextInt(height / 2);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        for (int i = 0; i < CLOUD_COUNT; i++) {
            int x = xPositions[i];
            int y = yPositions[i];
            g.fillOval(x, y, 60, 40);
            g.fillOval(x + 30, y, 60, 40);
            g.fillOval(x + 15, y - 15, 50, 50);
        }
    }
}