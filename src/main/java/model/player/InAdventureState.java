package model.player;

import controller.JavaFXController;
import javafx.scene.input.KeyEvent;
import model.game.Game;
import model.room.*;

public class InAdventureState implements PlayerState{

    Player player;

    Game game;

    public InAdventureState(Game game) {
        this.game = game;
        //this.player = game.getPlayer();
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP:    game.getPlayer().goNorth(); break;
            case DOWN:  game.getPlayer().goSouth(); break;
            case LEFT:  game.getPlayer().goWest(); break;
            case RIGHT: game.getPlayer().goEast(); break;
            case ENTER: new TreasureRoom().event(game);
                System.out.println(player.getLife());
                ;break;
            case I:  game.getPlayer().openInventory(); break;
    }
    }
}
