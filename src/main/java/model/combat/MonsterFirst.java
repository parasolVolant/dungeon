package model.combat;

import model.player.Player;
import model.roomElement.monster.Monster;

public class MonsterFirst extends AbstractCombatSystem{


    public MonsterFirst(Player player) {
        super(player);
        this.sb = new StringBuilder();
    }




    @Override
    public void fight(Monster monster) {
        sb.append("A fight begins ! A wild "+ monster.getName() +" appears"); sb.append("\n");
        while (!player.isDead() && !monster.isDead() ){
            monster.hit(player);
            sb.append(monster.getName() + " hits : your life : "+ player.getLife()); sb.append("\n");
            if(player.isDead()) {sb.append("You lost the fight"); System.out.println(sb.toString()); return;}
            else if(monster.isDead()) {sb.append("You won the fight"); System.out.println(sb.toString()); return;}
            player.hit(monster);
            sb.append("You hits  " + monster.getName() + " life : "+ monster.getLife());  sb.append("\n");
            if(monster.isDead()){ sb.append("You won the fight");System.out.println(sb.toString());return;}
            else if(player.isDead()) {sb.append("You lost the fight"); System.out.println(sb.toString()); return;}
        }


    }
}
