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
    public void hit(Player player) {
        player.setLife(player.getLife() - this.strength);
    }

    @Override
    public boolean isDead() {
        return life <= 0;
    }
}
