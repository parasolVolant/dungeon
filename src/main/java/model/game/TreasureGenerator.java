package model.game;

import model.roomElement.RoomElement;
import model.roomElement.treasure.Treasure;

public class TreasureGenerator extends AbstractGenerator{


    @Override
     public RoomElement generate() {
        return new Treasure() {
            @Override
            public String getName() {
                return "Treasure";
            }
        };
    }
}
