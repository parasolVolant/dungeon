package model.room_element.trap;

import model.player.Player;

public class Net implements Trap {

    int damage = 1;

    @Override
    public void hurt(Player player) {
        //TODO
    }

    @Override
    public String description() {
        return "You were caught in a Net! \nYou lose " + damage + " hp.";
    }
}
