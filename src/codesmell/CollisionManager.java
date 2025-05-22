/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesmell;

/**
 *
 * @author Friends com
 */
import java.awt.Rectangle;
import java.util.ArrayList;

public class CollisionManager {

    public void checkCollision(Bird bird, ArrayList<Rectangle> columns, GameState gameState, GameStateManager gameStateManager, int height) {
        Rectangle birdRect = bird.getRectangle();

        for (Rectangle column : columns) {
            // Score increment
            if (column.y == 0 &&
    bird.getMiddleX() > column.x + column.width / 2 - 10 &&
    bird.getMiddleX() < column.x + column.width / 2 + 10) {
    if (!gameState.gameOver) {
        gameState.score++;
    }
}

            // Collision detection
            if (column.intersects(birdRect)) {
                handleGameOver(gameState, gameStateManager);

                if (birdRect.x <= column.x) bird.x = column.x - bird.width;
                else if (column.y != 0) bird.y = column.y - bird.height;
                else if (bird.y < column.height) bird.y = column.height;
            }
        }

        // Boundary check
        if (bird.y > height - 120 || bird.y < 0) {
            handleGameOver(gameState, gameStateManager);
        }
    }

    private void handleGameOver(GameState gameState, GameStateManager gameStateManager) {
        gameState.gameOver = true;
        gameStateManager.endGame();
    }
}
