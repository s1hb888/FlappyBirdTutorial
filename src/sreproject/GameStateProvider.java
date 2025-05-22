package sreproject;

public interface GameStateProvider {
    void resetGame(Bird bird, ColumnManager columnManager, int width, int height);
}