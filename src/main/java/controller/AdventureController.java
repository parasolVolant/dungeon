package controller;

import javafx.scene.input.KeyEvent;
import model.game.Game;
import model.player.Player;
import model.room.*;

public class AdventureController implements GameController {

    Player player;

    Game game;

    public AdventureController(Game game) {
        this.game = game;
        this.player = game.getPlayer();
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP:    player.goNorth(); break;
            case DOWN:  player.goSouth(); break;
            case LEFT:  player.goWest(); break;
            case RIGHT: player.goEast(); break;
            case ENTER: new MonsterRoom().event(game);
                System.out.println(player.getLife());
                ;break;
            case I:  player.openInventory(); break;
    }
    }
}