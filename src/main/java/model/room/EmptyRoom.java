package model.room;

import model.Move;
import model.game.Game;
import model.player.Player;

public class EmptyRoom implements Room{

    @Override
    public void event(Game game) {
        game.getView().handleMove(new Move(
                "The room is empty."
        ));
    }
}
