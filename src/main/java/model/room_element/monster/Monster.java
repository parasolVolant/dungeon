package model.room_element.monster;

import model.player.Player;

public interface Monster {

    public String getName();
    public int getLife();
    public int getStrength();
    public void setLife(int lifeValue);
    public void setStrength(int strengthValue);
    public void hit(Player player);
    public boolean isDead();


}
