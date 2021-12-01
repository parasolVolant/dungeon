package model.room_element.treasure;

import model.player.Player;

public interface Treasure {

    String getName();
    void equip(Player player);

}
