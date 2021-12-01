package model.room_element.treasure.weapon;

import model.player.Player;
import model.room_element.treasure.Treasure;

public class Stick extends Weapon {

    public Stick() {
        addedStrength = 1;
    }

    @Override
    public String getName() {
        return "Wooden Stick";
    }

}
