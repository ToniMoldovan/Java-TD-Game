package main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameScreen extends JPanel{
    private Dimension size;
    private Render render;
    private Game game;

    // Constructor
    public GameScreen(Game game) {
        this.game = game;
        render = new Render(this);

        setPanelSize();
    }

    private void setPanelSize() {
        size = new Dimension(640, 640); // Set the size of the JPanel

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g); // This is required to draw the background and other things

        render.render(g);

    }
}