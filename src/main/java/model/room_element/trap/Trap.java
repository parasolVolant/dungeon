package model.room_element.trap;

import model.game.Game;
import model.player.Player;

public interface Trap {

    void hurt(Player player);
    String description();

}