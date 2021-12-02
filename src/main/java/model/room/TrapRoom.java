package model.room;

import model.Move;
import model.game.Game;
import model.player.Player;
import model.room_element.trap.Trap;
import model.room_element.trap.TrapGenerator;

public class TrapRoom implements Room{



    Trap trap = new TrapGenerator().createTrap();

    @Override
    public void event(Game game) {
        Player player = game.getPlayer();
        trap.hurt(player);
        game.getView().handleMove(new Move(
                trap.description()
        ));
    }
}
