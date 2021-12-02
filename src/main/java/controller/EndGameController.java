package controller;

import javafx.scene.input.KeyEvent;
import model.game.Game;

public class EndGameController implements GameController{




    Game game;

    public EndGameController(Game game) {
        this.game = game;

    }


    @Override
    public void handle(KeyEvent event) {

    }
}
