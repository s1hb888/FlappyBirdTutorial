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

public class BirdController {
    
    private GameState gameState;

    public BirdController(GameState gameState) {
        this.gameState = gameState;
    }

    public void applyGravity(int ticks) {
        if (ticks % 2 == 0 && gameState.yMotion < 15) {
            gameState.yMotion += 2;
        }
        gameState.yMotion = gameState.yMotion;
    }

    public void jump() {
        if (gameState.yMotion > 0) gameState.yMotion = 0;
        gameState.yMotion -= 10;
        gameState.yMotion = gameState.yMotion;
    }

    public void moveBird(Bird bird) {
        bird.y += gameState.yMotion;
    }
}

