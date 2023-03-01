package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Render {

    private GameScreen gameScreen;
    private Random random;

    private BufferedImage image;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();

    public Render(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        importImg();
        loadSpritesFromImageIntoArray();
        random = new Random();
    }

    public void render(Graphics g) {
        switch (GameStates.gameState) {
            case MENU:
                for (int y = 0; y < 20; y++) {
                    for (int x = 0; x < 20; x++) {
                        g.drawImage(sprites.get(random.nextInt(100)), x * 32, y * 32, null);
                    }
                }
                break;
            case PLAYING:
                break;
            case SETTINGS:
                break;
        }
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

    private void loadSpritesFromImageIntoArray() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                sprites.add(image.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }


}
