package model.room_element.monster;

public class Orc extends AbstractMonster {

    public Orc() {
        this.life = 15;
        this.strength = 1;
        this.name = "Orc";
    }

    @Override
    public String getName() {
        return "Orc";
    }
}
