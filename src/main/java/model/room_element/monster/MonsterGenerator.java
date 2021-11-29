package model.room_element.monster;

import java.util.Random;

public class MonsterGenerator {


    static final int NUMBER_OF_MONSTER = 2;  //augmenter avec le nombre de monstre

    public Monster createMonster() {
        Random random = new Random();
        int randNb = random.nextInt(NUMBER_OF_MONSTER);
        Monster monster = null;

        switch (randNb) {
            case 0 : monster = new Orc(); break;
            case 1 : monster = new Goblin(); break;
        }

        return monster;
    }

}
