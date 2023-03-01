package scenes;

import main.Game;

public class GameScene {

    private Game game;

    //Constructor
    public GameScene(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

}
