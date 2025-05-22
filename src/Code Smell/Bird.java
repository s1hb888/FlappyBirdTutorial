/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sreproject;

/**
 *
 * @author Friends com
 */
import java.awt.Rectangle;

public class Bird {
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

    public int getMiddleX() {
        return x + width / 2;
    }
}


