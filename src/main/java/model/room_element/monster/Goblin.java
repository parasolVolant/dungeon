package model.room_element.monster;

public class Goblin extends AbstractMonster {

    public Goblin() {
        this.life = 10;
        this.strength = 2;
        this.name = "Goblin";
    }


    @Override
    public String getName() {
        return "Goblin";
    }

}