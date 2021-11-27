package model.roomElement.treasure;

import model.player.Player;
import model.roomElement.RoomElement;

public interface Treasure extends RoomElement {

    void equip(Player player);

}
