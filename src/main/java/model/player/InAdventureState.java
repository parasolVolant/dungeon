package model.player;

import javafx.scene.input.KeyEvent;

public class InAdventureState implements PlayerState{

    Player player;

    public InAdventureState(Player player) {
        this.player = player;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP:    player.goNorth(); break;
            case DOWN:  player.goNorth(); break;
            case LEFT:  player.goNorth(); break;
            case RIGHT: player.goNorth(); break;
            case I:  player.openInventory(); break;
    }
    }
}
