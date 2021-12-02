package model.room_element.treasure;

import model.player.Player;

public class Potion implements Treasure {

    int addedLife = 5;

    @Override
    public String getName() {
        return "Potion";
    }

    @Override
    public void equip(Player player) {
        System.out.println(player.getLife());
        if(addedLife + player.getLife() > player.getMaxLife()) addedLife = player.getMaxLife() - player.getLife();
        player.setLife(player.getLife() + addedLife);
        System.out.println(player.getLife());
    }
}






