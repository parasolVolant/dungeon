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
            case NUMPAD1 :
            case DIGIT1 : player.useItem(1); break;
            case ENTER : player.openInventory(); break;

        }
    }
}
