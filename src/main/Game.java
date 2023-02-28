package main;

import javax.swing.JFrame;

public class Game extends JFrame {

    private GameScreen gameScreen; // The game screen

    // Constructor
    public Game() {
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window at startup

        gameScreen = new GameScreen();
        add(gameScreen);
    }
}