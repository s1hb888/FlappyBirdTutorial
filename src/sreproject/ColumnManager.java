package sreproject;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class ColumnManager {
    private ArrayList<Rectangle> columns = new ArrayList<>();

    public void addColumn(Rectangle column) {
        columns.add(column);
    }

    public void moveColumns(int speed) {
        for (Rectangle column : columns) {
            column.x -= speed;
        }
    }

   public void removeOffscreenColumns(Runnable onRemovePair) {
    Iterator<Rectangle> iterator = columns.iterator();
    boolean removed = false;

    while (iterator.hasNext()) {
        Rectangle column = iterator.next();
        if (column.x + column.width < 0) {
            iterator.remove(); // Safely remove via iterator
            removed = true;
        }
    }

    if (removed && onRemovePair != null) {
        onRemovePair.run(); // Trigger callback to add new column(s)
    }
}

    public void reset() {
        columns.clear();
    }

    public ArrayList<Rectangle> getColumns() {
        return columns;
    }
}