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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ColumnManager {
    private ArrayList<Rectangle> columns = new ArrayList<>();
    private int WIDTH, HEIGHT;
    private Random rand = new Random();

    public ColumnManager(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    public void addColumn(boolean start) {
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);

        int x;
        if (start) {
            x = WIDTH + columns.size() * 300;
        } else {
            x = columns.get(columns.size() - 1).x + 600;
        }

        // bottom column
        columns.add(new Rectangle(x, HEIGHT - height - 120, width, height));
        // top column
        columns.add(new Rectangle(x, 0, width, HEIGHT - height - space));
    }

    public void moveColumns(int speed) {
        for (Rectangle column : columns) {
            column.x -= speed;
        }
    }

    public void removeOffscreenColumns(Runnable onRemovePair) {
        ArrayList<Rectangle> toRemove = new ArrayList<>();
        Iterator<Rectangle> iterator = columns.iterator();
while (iterator.hasNext()) {
    Rectangle column = iterator.next();
    if (column.x + column.width < 0) {
        iterator.remove(); // ✅ Safe removal
       // onRemove.run();    // Or whatever callback you want to execute
    }
}

        columns.removeAll(toRemove);
    }

    public void reset() {
        columns.clear();
    }

    public ArrayList<Rectangle> getColumns() {
        return columns;
    }
}


