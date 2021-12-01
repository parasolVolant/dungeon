package model.player;

import javafx.scene.input.KeyEvent;
import model.game.Game;
import model.room.*;

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
            case ENTER: new TreasureRoom().event(player);
                System.out.println(player.getLife());
                ;break;
            case I:  player.openInventory(); break;
    }
    }
}
