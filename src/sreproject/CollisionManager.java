package sreproject;

import java.awt.Rectangle;
import java.util.List;

public class CollisionManager implements CollisionHandler {
    @Override
    public void checkCollision(Bird bird, List<Rectangle> columns, GameState gameState, GameStateProvider gameStateProvider, int height) {
        for (Rectangle column : columns) {
            if (column.intersects(bird.getRectangle())) {
                gameState.gameOver = true;
            }
        }

        if (bird.getY() > height - 120 || bird.getY() < 0) {
            gameState.gameOver = true;
        }
  
        if (bird.getY() + bird.getHeight() >= height - 120) {
            bird.setY(height - 120 - bird.getHeight());
        }
    }
}