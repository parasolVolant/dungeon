package model.roomElement.monster;

import model.player.Player;
import model.roomElement.RoomElement;

public interface Monster extends RoomElement {

    public String getName();
    public int getLife();
    public int getStrength();
    public void setLife(int lifeValue);
    public void setStrength(int strengthValue);
    public void hit(Player player);
    public boolean isDead();


}
