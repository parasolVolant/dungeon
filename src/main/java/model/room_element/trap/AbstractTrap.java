package model.room_element.trap;

import model.player.Player;



public abstract class AbstractTrap implements Trap {

    int damage;

    @Override
    public void hurt(Player player) {
        player.setLife(player.getLife() - damage);
        if(player.isDead()){
            System.out.println("You are dead...");
        }


    }

    public abstract String description();

}


