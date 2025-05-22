package sreproject;

import java.awt.Rectangle;

public class GameStateManager {

    private GameState gameState;

    public GameStateManager(GameState gameState) {
        this.gameState = gameState;
    }

    public boolean isGameOver() {
        return gameState.gameOver;
    }

    public boolean isGameStarted() {
        return gameState.started;
    }

    public void startGame() {
        gameState.started = true;
    }

    public void endGame() {
        gameState.gameOver = true;
    }

    public void resetGame(Bird bird, ColumnManager columnManager, int width, int height) {
        // Reset bird position
        bird.x = width / 2 - 10;
        bird.y = height / 2 - 10;

        // Reset column manager
        columnManager.reset();

        // Reset game state
        gameState.started = false;
        gameState.gameOver = false;
        gameState.score = 0;
        gameState.yMotion = 0;
        gameState.ticks = 0;
    }
}
