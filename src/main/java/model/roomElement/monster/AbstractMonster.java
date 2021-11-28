package model.roomElement.monster;

import model.game.Route;
import model.player.Player;

public class AbstractMonster implements Monster{


    protected int life;
    protected int strength;
    protected String name;





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
        this.life = lifeValue;
    }


    @Override
    public void setStrength(int strengthValue) {
        this.strength = strengthValue;
    }

    @Override
    public void hit(Player player){
        player.setLife(player.getLife()-this.getStrength());
    }

    @Override
    public boolean isDead() {
        return life <= 0;
    }

}
