package model.room;

import model.Move;
import model.game.Game;
import model.player.Player;
import model.room_element.trap.Trap;
import model.room_element.trap.TrapGenerator;

public class TrapRoom implements Room{


    //TODO
    Trap trap = new TrapGenerator().createTrap();

    @Override
    public void event(Game game) {
        trap.hurt(game.getPlayer());
        game.getView().handleMove(new Move(
                trap.description()
        ));
    }
}
