package model.room;

import model.Move;
import model.player.Player;

public class EmptyRoom implements Room{

    @Override
    public void event(Player player) {
        player.getView().handleMove(new Move(
                "The room is empty."
        ));
    }
}
