package model.room;

import model.Move;
import model.player.Player;
import model.roomElement.treasure.Potion;
import model.roomElement.treasure.Stick;
import model.roomElement.treasure.Treasure;
import model.roomElement.treasure.TreasureGenerator;

public class TreasureRoom implements Room{

    Treasure item = new TreasureGenerator().createTreasure();

    @Override
    public void event(Player player) {
        StringBuilder message = new StringBuilder("You found a "+item.toString()+". \n");
        if(player.isFull()) {
            message.append("Unfortunately, your inventory is full.");
        } else {
            message.append("You put it in your inventory.");
            player.getInventory().addItem(item);
        }
        player.getView().handleMove(new Move(message.toString()));
    }
}
