package model.game;

import model.roomElement.RoomElement;
import model.roomElement.trap.Trap;

public class TrapGenerator extends  AbstractGenerator{


    @Override
    public RoomElement generate() {
        return new Trap() {
            @Override
            public String getName() {
                return "Trap";
            }
        };
    }
}
