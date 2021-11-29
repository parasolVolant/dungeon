package model.room;

import java.util.Random;

public class RoomGenerator {

    static final int NUMBER_OF_ROOM = 3;  //augmenter avec le nombre de room

    public Room createRoom() {
        Random random = new Random();
        int randNb = random.nextInt(NUMBER_OF_ROOM);
        Room room = null;

        switch (randNb) {
            case 0 : room = new MonsterRoom(); break;
            case 1 : room = new TrapRoom(); break;
            case 2 : room = new TreasureRoom(); break;
        }

        return room;
    }

}
