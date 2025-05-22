package sreproject;

public class BirdController implements BirdMovementHandler {

    private GameState gameState;

    public BirdController(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void jump() {
        if (gameState.yMotion > 0) {
            gameState.yMotion = 0;
        }
        gameState.yMotion -= 10;
    }

    @Override
    public void applyGravity(int ticks) {
        if (ticks % 2 == 0 && gameState.yMotion < 15) {
            gameState.yMotion += 2;
        }
    }

    @Override
    public void moveBird(Bird bird) {
        bird.setY(bird.getY() + gameState.yMotion);
    }
}