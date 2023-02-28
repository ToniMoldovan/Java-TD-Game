package main;

import javax.swing.JPanel;
import java.awt.*;

public class GameScreen extends JPanel{

    // Constructor
    public GameScreen() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // This is required to draw the background and other things

        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 100); // Draw a rectangle

    }

}