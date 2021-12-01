package model.player;

import javafx.scene.input.KeyEvent;

public class InInventoryState implements PlayerState{

    Player player;

    public InInventoryState(Player player) {
        this.player = player;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case I:  player.closeInventory(); break;
            case UP: player.getInventory().decreaseIndex(); break;
            case DOWN: player.getInventory().increaseIndex(); break;
            case A: player.useItem(); break;
            case Z: player.deleteItem(); break;
        }
    }
}
