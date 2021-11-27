package model.room;

import model.Move;
import model.player.Player;
import model.roomElement.treasure.Potion;
import model.roomElement.treasure.Stick;
import model.roomElement.treasure.Treasure;

public class TreasureRoom implements Room{

    Treasure item = new Stick();

    @Override
    public void event(Player player) {
        String message = "You found a "+item.getName()+". \n";
        if(player.isFull()) {
            message+= "Unfortunately, your inventory is full.";
        } else {
            message+= "You put it in your inventory.";
            player.getInventory().addItem(item);
        }
        player.getView().handleMove(new Move(message));
    }
}
