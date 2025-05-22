package sreproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Column extends Rectangle implements Renderable {

    public Column(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green.brighter());
        g.fillRect(x, y, width, height);
    }
}