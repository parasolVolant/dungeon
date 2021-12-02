package controller;

import javafx.scene.input.KeyEvent;
import model.game.Game;
import model.player.Player;

public class StatusController implements GameController{


    Game game;

    public StatusController(Game game) {
        this.game = game;
    }

    @Override
    public void handle(KeyEvent event) {
        Player player = game.getPlayer();
        switch (event.getCode()) {
            case U: player.closeStatus();
        }
    }
}
