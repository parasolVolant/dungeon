package model.room_element.treasure.weapon;

public class Sword extends Weapon{

    public Sword() {
        addedStrength = 3;
    }

    @Override
    public String getName() {
        return "Sword";
    }
}
