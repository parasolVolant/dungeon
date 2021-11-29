package model.room;

import model.Move;
import model.player.Player;
import model.room_element.trap.Trap;
import model.room_element.trap.TrapGenerator;

public class TrapRoom implements Room{


    //TODO
    Trap trap = new TrapGenerator().createTrap();

    @Override
    public void event(Player player) {
        trap.hurt(player);
        player.getView().handleMove(new Move(
                trap.description()
        ));
    }
}
