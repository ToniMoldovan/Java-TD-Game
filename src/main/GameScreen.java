package main;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class GameScreen extends JPanel{
    private Random random;

    // Constructor
    public GameScreen() {
        random = new Random();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // This is required to draw the background and other things


        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                g.fillRect(x * 32, y * 32, 32, 32);
            }
        }

    }

}