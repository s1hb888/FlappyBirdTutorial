package sreproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FlappyBird implements ActionListener {

    public static FlappyBird flappyBird;

    private FlappyBirdGameContext context = new FlappyBirdGameContext();
    private RenderManager renderer;
    private Bird bird;
    private ColumnManager columnManager;
    private ObstacleSpawner obstacleSpawner;
    private GameState gameState;
    private GameStateManager gameStateManager;
    private BirdController birdController;
    private CollisionManager collisionManager;
    private Timer timer;

    // Track which top columns have been scored
    private ArrayList<Rectangle> scoredColumns = new ArrayList<>();

    public FlappyBird() {
        JFrame jframe = new JFrame();
        timer = new Timer(20, this); // Use 'this' instead of new GameLoop()
        renderer = new RenderManager(context);

        // Initialize core game components
        bird = new Bird(context.WIDTH / 2 - 10, context.HEIGHT / 2 - 10, 20, 20);
        columnManager = new ColumnManager();
        gameState = new GameState();
        gameStateManager = new GameStateManager(gameState);
        birdController = new BirdController(gameState);
        collisionManager = new CollisionManager();

        // Set up obstacle spawner and initial columns
        obstacleSpawner = new ObstacleSpawner(columnManager, context.WIDTH, context.HEIGHT);
        addInitialColumns();

        renderer.addRenderable(new BackgroundRenderer(context.WIDTH, context.HEIGHT));
        renderer.addRenderable(new GroundRenderer(context.WIDTH, context.HEIGHT));
        renderer.addRenderable(new CloudRenderer(context.WIDTH, context.HEIGHT));
        renderer.addRenderable(bird); // Assumes Bird implements Renderable
        renderer.addRenderable(new ColumnRenderer(columnManager.getColumns()));
        renderer.addRenderable(new MessageRenderer(gameState, context));

        // Setup JFrame
        jframe.add(renderer);
        jframe.setTitle("Flappy Bird");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(context.WIDTH, context.HEIGHT);
        jframe.setResizable(false);
        jframe.setVisible(true);

        // Input listeners
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

        timer.start(); // Start the game loop
    }

    public void jump() {
        if (gameState.gameOver) {
            gameStateManager.resetGame(bird, columnManager, context.WIDTH, context.HEIGHT);
            gameState.gameOver = false;
            gameState.started = false;
            gameState.yMotion = 0;
            gameState.score = 0;
            scoredColumns.clear();  // Clear scored columns on reset
            addInitialColumns();
        } else if (!gameState.started) {
            gameState.started = true;
        } else {
            birdController.jump();
        }
    }

    private void addInitialColumns() {
        columnManager.reset();
        obstacleSpawner.spawnInitialColumns(3);
    }

    // Game loop logic directly in FlappyBird
    @Override
    public void actionPerformed(ActionEvent e) {
        gameState.ticks++;

        if (gameState.started) {
            columnManager.moveColumns(10);
            birdController.applyGravity(gameState.ticks);
            birdController.moveBird(bird);
            columnManager.removeOffscreenColumns(() -> obstacleSpawner.spawnColumn(context.HEIGHT));
            collisionManager.checkCollision(bird, columnManager.getColumns(), gameState, gameStateManager, context.HEIGHT);

            // Update score
            for (Rectangle column : columnManager.getColumns()) {
                if (column.y == 0 && !scoredColumns.contains(column) && (column.x + column.width) < bird.getX()) {
                    gameState.score++;
                    scoredColumns.add(column);
                }
            }
        }

        renderer.repaint(); // Repaint through RenderManager
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
        return context.WIDTH;
    }

    public int getHEIGHT() {
        return context.HEIGHT;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            flappyBird = new FlappyBird();
        });
    }
}
