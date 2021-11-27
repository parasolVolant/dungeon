package model.roomElement.monster;

import model.roomElement.trap.Net;
import model.roomElement.trap.Pit;
import model.roomElement.trap.Trap;

import java.util.Random;

public class MonsterGenerator {


    static final int NUMBER_OF_MONSTER = 2;  //augmenter avec le nombre de trap

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
