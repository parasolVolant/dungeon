package model.room;

import model.Move;
import model.game.Game;
import model.player.Player;
import model.room_element.treasure.Treasure;
import model.room_element.treasure.TreasureGenerator;

public class TreasureRoom implements Room{

    Treasure item = new TreasureGenerator().createTreasure();

    @Override
    public void event(Game game) {
        Player player = game.getPlayer();

        StringBuilder message = new StringBuilder("You found a "+item.getName()+". \n");
        if(player.isFull()) {
            message.append("Unfortunately, your inventory is full.");
        } else {
            message.append("You put it in your inventory.");
            player.getInventory().addItem(item);
        }
        game.getView().handleMove(new Move(message.toString()));
    }


}

