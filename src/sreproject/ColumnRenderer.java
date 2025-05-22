/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sreproject;

/**
 *
 * @author SHAMILA HUMAYUN
 */
import java.awt.*;
import java.util.List;

public class ColumnRenderer implements Renderable {
    private List<Rectangle> columns;

    public ColumnRenderer(List<Rectangle> columns) {
        this.columns = columns;
    }

    @Override
    public void render(Graphics g) {
        for (Rectangle column : columns) {
            g.setColor(Color.green.darker());
            g.fillRect(column.x, column.y, column.width, column.height);
        }
    }
}
