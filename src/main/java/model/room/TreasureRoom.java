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
        StringBuilder message = new StringBuilder("You found a "+item.toString()+". \n");
        if(game.getPlayer().isFull()) {
            message.append("Unfortunately, your inventory is full.");
        } else {
            message.append("You put it in your inventory.");
            game.getPlayer().getInventory().addItem(item);
        }
        game.getView().handleMove(new Move(message.toString()));
    }
}
