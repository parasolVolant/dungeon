package model.room_element.monster;

import model.player.Player;

public interface Monster {

     String getName();
     int getLife();
     int getStrength();
     void setLife(int lifeValue);
     void hit(Player player);
     boolean isDead();


}
