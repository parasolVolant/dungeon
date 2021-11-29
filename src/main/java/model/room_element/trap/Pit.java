package model.room_element.trap;

import model.player.Player;

public class Pit implements Trap{

    int damage = 2;

    @Override
    public void hurt(Player player) {
        //TODO
    }

    @Override
    public String description() {
        return "You fell into a Hidden Pit! \nYou lose " + damage + " hp while climbing back up.";
    }
}
