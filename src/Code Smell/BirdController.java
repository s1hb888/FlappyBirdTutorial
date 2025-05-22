/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sreproject;

/**
 *
 * @author Friends com
 */


import java.awt.Rectangle;

public class BirdController {
    private int yMotion = 0;
    private GameState gameState;

    public BirdController(GameState gameState) {
        this.gameState = gameState;
    }

    public void applyGravity(int ticks) {
        if (ticks % 2 == 0 && yMotion < 15) {
            yMotion += 2;
        }
        gameState.yMotion = yMotion;
    }

    public void jump() {
        if (yMotion > 0) yMotion = 0;
        yMotion -= 10;
        gameState.yMotion = yMotion;
    }

    public void moveBird(Bird bird) {
        bird.y += yMotion;
    }
}

