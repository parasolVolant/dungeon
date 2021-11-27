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
            case DIGIT1: player.useItem(0); break;
            case DIGIT2: player.useItem(1); break;
            case DIGIT3: player.useItem(2); break;
            case DIGIT4: player.useItem(3); break;
            case DIGIT5: player.useItem(4); break;
        }
    }
}
