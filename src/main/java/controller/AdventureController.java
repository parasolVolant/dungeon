package controller;

import javafx.scene.input.KeyEvent;
import model.game.Game;
import model.player.Player;
import model.room.TrapRoom;
import model.room.TreasureRoom;

public class AdventureController implements GameController{

    Game game;

    public AdventureController(Game game) {
        this.game = game;
    }

    @Override
    public void handle(KeyEvent event) {
        Player player = game.getPlayer();

        switch (event.getCode()) {
            case UP:    player.goNorth(); break;
            case DOWN:  player.goSouth(); break;
            case LEFT:  player.goWest(); break;
            case RIGHT: player.goEast(); break;
            case U: player.openStatus(); break;
            case ENTER: new TrapRoom().event(game); break;
            case I:  player.openInventory(); break;
        }
    }
}





