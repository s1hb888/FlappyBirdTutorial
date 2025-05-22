package sreproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bird implements Renderable {
    public int x, y, width, height;

    public Bird(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        Rectangle rect = getRectangle();
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
}