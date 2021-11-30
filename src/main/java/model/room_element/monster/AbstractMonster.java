package model.room_element.monster;

import model.player.Player;

public class AbstractMonster implements Monster{

    int life;
    int strength;
    String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setLife(int lifeValue) {
        life = lifeValue;
    }

    @Override
    public void setStrength(int strengthValue) {
        strength = strengthValue;
    }

    @Override
    public void hit(Player player) {
        System.out.println("tu tapes le monstre ma belle");
        player.setLife(player.getLife() - this.strength);
        System.out.println(player.getLife());
    }

    @Override
    public boolean isDead() {
        return life <= 0;
    }
}
