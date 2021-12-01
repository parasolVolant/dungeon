package model.room;

import model.Move;
import model.player.EndGameState;
import model.player.Player;

public class LastRoom implements Room{
    @Override
    public void event(Player player) {
        player.getView().handleMove(new Move("You reached the end of the dungeon."));
        player.changeState(new EndGameState(player));
    }
}
