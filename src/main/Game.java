package main;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game extends JFrame implements Runnable{

    private GameScreen gameScreen; // The game screen
    private BufferedImage image; // The sprite atlas
    private Thread gameThread; // The game thread

    private final double FPS_SET = 120.0; // The frames per second
    private final double UPS_SET = 60.0; // The updates per second

    // Constructor
    public Game() {
        importImg();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window at startup

        gameScreen = new GameScreen(image);
        add(gameScreen);

        pack(); // This is required to make the window the size of the JPanel
        setVisible(true);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

        try {
            if (is != null) {
                image = ImageIO.read(is);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /***** Game Start method ******/
    public void start() {
        gameThread = new Thread(this); // we pass this because the class implements Runnable
        gameThread.start();
    }

    private void updateGame() {
        // Update the game

    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET; // this is 120 frames per second
        double timePerUpdate = 1000000000.0 / UPS_SET; // this is 60 updates per second

        long timeSinceLastFrame = System.nanoTime(); // The time since the last frame was drawn in nanoseconds
        long timeSinceLastUpdate = System.nanoTime(); // The time since the last update was done in nanoseconds

        long lastTime = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long now;

        while (true) {

            now = System.nanoTime();

            //Render
            if (System.nanoTime() - timeSinceLastFrame >= timePerFrame) {
                timeSinceLastFrame = now;
                repaint();
                frames++;
            }

            //Update
            if (System.nanoTime() - timeSinceLastUpdate >= timePerUpdate) {
                timeSinceLastUpdate = now;
                updateGame();
                updates++;
            }

            // FPS and UPS counter
            if (System.currentTimeMillis() - lastTime >= 1000) {
                System.out.println("FPS: " + frames + "\t| UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTime = System.currentTimeMillis();
            }
        }
    }
}