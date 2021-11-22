package model.game;

import model.roomElement.monster.Goblin;
import model.roomElement.monster.Orc;
import model.roomElement.RoomElement;

import java.util.Random;

public class MonsterGenerator extends AbstractGenerator{



    @Override
    public RoomElement generate() {

        addElement(new Orc());
        addElement(new Goblin());



        Random random = new Random();
        int eltIndex = random.nextInt(elements.size());
        System.out.println(eltIndex);
        return elements.get(eltIndex);
    }
}
