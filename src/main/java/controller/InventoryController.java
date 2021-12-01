package controller;

import javafx.scene.input.KeyEvent;
import model.game.Game;
import model.player.Player;

public class InventoryController implements GameController {

    Player player;

    Game game;

    public InventoryController(Game game) {

        this.game = game;
        this.player = game.getPlayer();
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case I:  player.closeInventory(); break;
            case DIGIT1: player.useItem(0); break;
            case DIGIT2: player.useItem(1); break;
            case DIGIT3: player.useItem(2); break;
            case DIGIT4: player.useItem(3); break;
            case DIGIT5: player.useItem(4); break;
        }
    }
}
