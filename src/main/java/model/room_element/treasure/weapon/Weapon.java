package model.room_element.treasure.weapon;

import model.player.Player;
import model.room_element.treasure.Treasure;

public abstract class Weapon implements Treasure {

    int addedStrength;

    public abstract String getName();

    @Override
    public void equip(Player player) {
        System.out.println(player.getBaseStrength());
        player.setStrength(player.getBaseStrength() + addedStrength);
        System.out.println(player.getStrength());
        player.setWeapon(this);
    }

    public int getAddedStrength() {
        return addedStrength;
    }

}
