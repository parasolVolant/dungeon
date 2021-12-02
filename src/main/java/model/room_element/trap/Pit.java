package model.room_element.trap;

import model.player.Player;

public class Pit extends AbstractTrap{

    public Pit(){
        damage = 2;
    }

    @Override
    public String description() {
        return "You fell into a Hidden Pit! \nYou lose " + damage + " hp while climbing back up.";
    }
}





