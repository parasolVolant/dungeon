package model.player;

import javafx.scene.input.KeyEvent;
import model.room.FirstRoom;
import model.room.LastRoom;
import model.room.TrapRoom;
import model.room.TreasureRoom;

public class InAdventureState implements PlayerState{

    Player player;

    public InAdventureState(Player player) {
        this.player = player;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP:    player.goNorth(); break;
            case DOWN:  player.goSouth(); break;
            case LEFT:  player.goWest(); break;
            case RIGHT: player.goEast(); break;
            case ENTER: new TrapRoom().event(player); break;
            case I:  player.openInventory(); break;
    }
    }
}
