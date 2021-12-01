package controller;

import javafx.scene.input.KeyEvent;
import model.game.Game;
import model.player.Player;

public class InventoryController implements GameController {


    Game game;

    public InventoryController(Game game) {
        this.game = game;

    }

    @Override
    public void handle(KeyEvent event) {
        Player player = game.getPlayer();
        switch (event.getCode()) {
            case I:  player.closeInventory(); break;
            case UP: player.getInventory().decreaseIndex(); break;
            case DOWN: player.getInventory().increaseIndex(); break;
            case A: player.useItem(); break;
            case Z: player.deleteItem(); break;
        }
    }


}
