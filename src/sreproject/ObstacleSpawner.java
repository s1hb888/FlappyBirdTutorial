package sreproject;

import java.util.Random;

import java.awt.Rectangle;
import java.util.Random;

public class ObstacleSpawner {
    private ColumnManager columnManager;
    private int width;
    private int height;
    private Random rand = new Random();

    public ObstacleSpawner(ColumnManager columnManager, int width, int height) {
        this.columnManager = columnManager;
        this.width = width;
        this.height = height;
    }

    public void spawnInitialColumns(int count) {
        for (int i = 0; i < count; i++) {
            spawnColumn(width + i * 300);
        }
    }

    public void spawnColumn(int x) {
        int space = 300;
        int colWidth = 100;
        int bottomHeight = 50 + rand.nextInt(300);
        int groundOffset = 120;

        // Bottom column
        columnManager.addColumn(new Rectangle(x, height - bottomHeight - groundOffset, colWidth, bottomHeight));
        // Top column
        columnManager.addColumn(new Rectangle(x, 0, colWidth, height - bottomHeight - space));
    }

    void spawnColumn() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}