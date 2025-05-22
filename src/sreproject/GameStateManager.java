package sreproject;

public class GameStateManager implements GameStateProvider {
    private GameState gameState;

    public GameStateManager(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void resetGame(Bird bird, ColumnManager columnManager, int width, int height) {
        bird.setY(height / 2 - 10);
        gameState.yMotion = 0;
        columnManager.reset();
    }
}