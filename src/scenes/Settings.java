package scenes;

import main.Game;

import java.awt.*;

public class Settings extends GameScene implements ISceneMethods{
    public Settings(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 640, 640);
    }
}
