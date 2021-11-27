package model.room;

import model.Move;
import model.player.Player;

public class FirstRoom implements Room{

    @Override
    public void event(Player player) {
        player.getView().handleMove(new Move("You entered the dungeon.\nWhere do you want to go?"));
    }
}
