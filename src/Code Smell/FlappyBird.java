/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sreproject;

/**
 *
 * @author Friends com
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlappyBird {

    public static FlappyBird flappyBird;

    public final int WIDTH = 800, HEIGHT = 800;

    private Renderer renderer;
    private Bird bird;
    private ColumnManager columnManager;
    private GameStateManager gameStateManager;
    private BirdController birdController;
    private CollisionManager collisionManager;
    private GameState gameState;
    private Timer timer;

    public FlappyBird() {
        JFrame jframe = new JFrame();
        timer = new Timer(20, new GameLoop());
        renderer = new Renderer(this);

        renderer.setFocusable(true);
        renderer.requestFocusInWindow();

        jframe.add(renderer);
        jframe.setTitle("Flappy Bird");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setResizable(false);
        jframe.setVisible(true);

        // Add listeners with adapters
        jframe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jump();
            }
        });

        jframe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    jump();
                }
            }
        });

        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
        columnManager = new ColumnManager(WIDTH, HEIGHT);
       gameState = new GameState();
       gameStateManager = new GameStateManager(gameState);
        birdController = new BirdController(gameState);
        collisionManager = new CollisionManager();

        addInitialColumns();
        timer.start();
    }

    public void jump() {
        if (gameState.gameOver) {
            gameStateManager.resetGame(bird, columnManager, WIDTH, HEIGHT);
            gameState.gameOver = false;
            gameState.started = false;
            gameState.yMotion = 0;
            addInitialColumns();
        } else if (!gameState.started) {
            gameState.started = true;
        } else {
            birdController.jump();
        }
    }

    private void addInitialColumns() {
        columnManager.reset();
        for (int i = 0; i < 4; i++) {
            columnManager.addColumn(true);
        }
    }

    private class GameLoop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameState.ticks++;

            if (gameState.started) {
                columnManager.moveColumns(10);
                birdController.applyGravity(gameState.ticks);
                birdController.moveBird(bird);
                columnManager.removeOffscreenColumns(() -> columnManager.addColumn(false));
                collisionManager.checkCollision(bird, columnManager.getColumns(), gameState, gameStateManager, HEIGHT);
            }

            renderer.repaint();
        }
    }

    public Bird getBird() {
        return bird;
    }

    public ColumnManager getColumnManager() {
        return columnManager;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            flappyBird = new FlappyBird();
        });
    }
}

