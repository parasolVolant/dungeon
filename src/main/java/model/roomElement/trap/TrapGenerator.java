package model.roomElement.trap;

import java.util.Random;

public class TrapGenerator {

    static final int NUMBER_OF_TRAP = 2;  //augmenter avec le nombre de trap

    public Trap createTrap() {
        Random random = new Random();
        int randNb = random.nextInt(NUMBER_OF_TRAP);
        Trap trap = null;

        switch (randNb) {
            case 0 : trap = new Net(); break;
            case 1 : trap = new Pit(); break;
        }

        return trap;
    }

}
