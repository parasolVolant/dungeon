package model.combat;

import model.Move;
import model.inventory.Inventory;
import model.player.Player;
import model.room_element.monster.Goblin;
import model.room_element.monster.Monster;

public class MonsterFirst implements CombatSystem{

    Player player;




    public MonsterFirst(Player player) {
        this.player = player;

    }

    @Override
    public void fight(Monster monster) {

        StringBuilder sb = new StringBuilder("A monster appeared! Fight!\n\n");

        while (true){

            monster.hit(player);

            sb.append(monster.getName() + " does " + monster.getStrength() + " damage. " +  " Your  remaining life is : "  + player.getLife()); sb.append("\n\n");

            if(player.isDead()) {

                sb.append("You lost the fight...");
                player.getView().handleMove(new Move(sb.toString()));
                return;
            }
            else if(monster.isDead()) {

                sb.append("You won the fight!");
                player.getView().handleMove(new Move(sb.toString()));
                return;
            }
            player.hit(monster);

            sb.append("You hit " + monster.getName() +  " and inflict " + player.getStrength() + " damage."); sb.append("\n\n");

            if(monster.isDead()) {

                sb.append("You won the fight!");
                player.getView().handleMove(new Move(sb.toString()));
                return;
            }

            else if(player.isDead()) {

                sb.append("You lost the fight...");
                player.getView().handleMove(new Move(sb.toString()));
                return;
            }

        }

    }





}
