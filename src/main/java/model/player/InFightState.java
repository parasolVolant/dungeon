package model.player;

import javafx.scene.input.KeyEvent;

public class InFightState implements PlayerState{

    Player player;

    public InFightState(Player player) {
        this.player = player;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case ENTER:  player.closeInventory(); break;
        }
    }
}
