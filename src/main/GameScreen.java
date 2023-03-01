package main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel{
    private Random random;
    private BufferedImage image;

    private Dimension size;

    private ArrayList<BufferedImage> sprites = new ArrayList<>();

    // Constructor
    public GameScreen(BufferedImage image) {
        this.image = image;

        setPanelSize();
        loadSprites();

        random = new Random();
    }

    private void setPanelSize() {
        size = new Dimension(640, 640); // Set the size of the JPanel

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    }

    private void loadSprites() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                sprites.add(image.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // This is required to draw the background and other things

        //g.drawImage(image, 0, 0, null);

        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                g.drawImage(sprites.get(random.nextInt(100)), x * 32, y * 32, null);
            }
        }

    }
}