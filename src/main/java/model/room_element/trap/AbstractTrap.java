package model.room_element.trap;

import model.player.Player;

public abstract class AbstractTrap implements Trap {

    int damage;

    @Override
    public void hurt(Player player) {
        player.setLife(player.getLife() - damage);
    }

    public abstract String description();

}





/*package model.room_element.trap;

import model.player.Player;

public abstract class AbstractTrap implements Trap{

    int damage;

    @Override
    public void hurt(Player player) {
        player.setLife(player.getLife() - damage);
    }

    public abstract String description();

}*/
