/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sreproject;

/**
 *
 * @author SHAMILA HUMAYUN
 */
import java.awt.*;

public class MessageRenderer implements Renderable {
    private GameState gameState;
    private FlappyBirdGameContext context;

    public MessageRenderer(GameState gameState, FlappyBirdGameContext context) {
        this.gameState = gameState;
        this.context = context;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 100));

        String message = null;
        int x = 0, y = 0;

        if (!gameState.started) {
            message = "Click to start!";
            x = 75;
            y = context.HEIGHT / 2 - 50;
        } else if (gameState.gameOver) {
            message = "Game Over!";
            x = 100;
            y = context.HEIGHT / 2 - 50;
        } else {
            message = String.valueOf(gameState.score);
            x = context.WIDTH / 2 - 25;
            y = 100;
        }

        g.drawString(message, x, y);
    }
}
