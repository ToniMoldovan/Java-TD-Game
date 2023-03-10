package main;

import inputs.KeyboardListener;
import inputs.MyMouseListener;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{

    private GameScreen gameScreen; // The game screen
    private Thread gameThread; // The game thread

    private final double FPS_SET = 120.0; // The frames per second
    private final double UPS_SET = 60.0; // The updates per second

    private boolean enableFPS_UPS_log = false; // Enable or disable the FPS and UPS log

    private MyMouseListener mouseListener;
    private KeyboardListener keyboardListener;

    //Classes
    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;

    // Constructor
    public Game() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initClasses();
        add(gameScreen);

        pack(); // This is required to make the window the size of the JPanel
        setLocationRelativeTo(null); // Center the window at startup

        setVisible(true);
    }

    private void initClasses() {
        gameScreen = new GameScreen(this);
        render = new Render(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
    }

    private void initInputs() {
        mouseListener = new MyMouseListener();
        keyboardListener = new KeyboardListener();

        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        addKeyListener(keyboardListener);

        requestFocus(); // This is required to make the JPanel listen to the keyboard
    }

    /***** Game Start method ******/
    public void start() {
        gameThread = new Thread(this); // we pass this because the class implements Runnable

        initInputs();

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
            if (now - timeSinceLastFrame >= timePerFrame) {
                timeSinceLastFrame = now;
                repaint();
                frames++;
            }

            //Update
            if (now - timeSinceLastUpdate >= timePerUpdate) {
                timeSinceLastUpdate = now;
                updateGame();
                updates++;
            }

            // FPS and UPS counter log
            if (System.currentTimeMillis() - lastTime >= 1000 && enableFPS_UPS_log) {
                System.out.println("FPS: " + frames + "\t| UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTime = System.currentTimeMillis();
            }
        }
    }

    public boolean isEnableFPS_UPS_log() {
        return enableFPS_UPS_log;
    }

    public void setEnableFPS_UPS_log(boolean enableFPS_UPS_log) {
        this.enableFPS_UPS_log = enableFPS_UPS_log;
    }

    // Getters and setters

    public Render getRender() {
        return render;
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Settings getSettings() {
        return settings;
    }
}