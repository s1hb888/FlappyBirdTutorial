package codesmell;

import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {

    private FlappyBird game;

    public Renderer(FlappyBird game) {
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGame(g);
    }

    private void paintGame(Graphics g) {
        drawBackground(g);
        drawGround(g);
        drawBird(g);
        drawColumns(g);
        drawMessages(g);
    }

    private void drawBackground(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
    }

    private void drawGround(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(0, game.getHEIGHT() - 120, game.getWIDTH(), 120);

        g.setColor(Color.green);
        g.fillRect(0, game.getHEIGHT() - 120, game.getWIDTH(), 20);
    }

    private void drawBird(Graphics g) {
        g.setColor(Color.red);
        Rectangle birdRect = game.getBird().getRectangle();
        g.fillRect(birdRect.x, birdRect.y, birdRect.width, birdRect.height);
    }

    private void drawColumns(Graphics g) {
        for (Rectangle column : game.getColumnManager().getColumns()) {
            paintColumn(g, column);
        }
    }

    private void drawMessages(Graphics g) {
        GameState gameState = game.getGameState();

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 100));

        String message = null;
        int x = 0, y = 0;

        if (!gameState.started) {
            message = "Click to start!";
            x = 75;
            y = game.getHEIGHT() / 2 - 50;
        } else if (gameState.gameOver) {
            message = "Game Over!";
            x = 100;
            y = game.getHEIGHT() / 2 - 50;
        } else {
            message = String.valueOf(gameState.score);
            x = game.getWIDTH() / 2 - 25;
            y = 100;
        }

        g.drawString(message, x, y);
    }

    private void paintColumn(Graphics g, Rectangle column) {
        g.setColor(Color.green.darker());
        g.fillRect(column.x, column.y, column.width, column.height);
    }
}
