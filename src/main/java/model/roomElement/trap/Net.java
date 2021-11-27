package model.roomElement.trap;

import model.player.Player;
import model.roomElement.trap.Trap;

public class Net implements Trap {

    int damage = 2;

    @Override
    public void hurt(Player player) {
        //TODO
    }

    @Override
    public String description() {
        return "You were caught in a Net! \nYou lose " + damage + " hp.";
    }
}
