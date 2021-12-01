package model.room_element.trap;

import model.player.Player;

public class Net extends AbstractTrap  {

    public Net(){
        damage = 2;
    }

    @Override
    public String description() {
        return "You were caught in a Net! \nYou lose " + damage + " hp.";
    }
}
