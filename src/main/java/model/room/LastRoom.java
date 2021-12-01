package model.room;

import model.Move;
import model.game.Game;
import model.player.Player;

public class LastRoom implements Room{
    @Override
    public void event(Game game) {
        game.getView().handleMove(new Move("You reached the end of the dungeon."));
    }
}
