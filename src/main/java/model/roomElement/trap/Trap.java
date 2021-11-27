package model.roomElement.trap;

import model.player.Player;

public interface Trap {

    void hurt(Player player);
    String description();

}
