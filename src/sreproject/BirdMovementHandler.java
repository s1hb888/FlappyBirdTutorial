package sreproject;

public interface BirdMovementHandler {
    void jump();
    void applyGravity(int ticks);
    void moveBird(Bird bird);
}