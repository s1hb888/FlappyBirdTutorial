package sreproject;

import java.awt.Rectangle;
import java.util.List;

public interface CollisionHandler {
    void checkCollision(Bird bird, List<Rectangle> columns, GameState gameState, GameStateProvider gameStateProvider, int height);
}