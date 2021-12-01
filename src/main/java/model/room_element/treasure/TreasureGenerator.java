package model.room_element.treasure;

import model.room_element.treasure.weapon.Stick;

import java.util.Random;

public class TreasureGenerator {

    static final int NUMBER_OF_TREASURE = 2;  //augmenter avec le nombre de trap

    public Treasure createTreasure() {
        Random random = new Random();
        int randNb = random.nextInt(NUMBER_OF_TREASURE);
        Treasure treasure = null;

        switch (randNb) {
            case 0 : treasure = new Potion(); break;
            case 1 : treasure = new Stick(); break;
        }

        return treasure;
    }

}
