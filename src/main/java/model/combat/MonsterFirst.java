package model.combat;

import model.Move;
import model.inventory.Inventory;
import model.player.Player;
import model.roomElement.monster.Goblin;
import model.roomElement.monster.Monster;

public class MonsterFirst implements CombatSystem{

    Player player;




    public MonsterFirst(Player player) {
        this.player = player;

    }

    @Override
    public void fight(Monster monster) {

        StringBuilder sb = new StringBuilder();

        while (!player.isDead() && !monster.isDead() ){

            monster.hit(player);

            sb.append(monster.getName() + " does " + monster.getStrength() + " damage. " +  " Your  remaining life is : "  + player.getLife()); sb.append("\n\n");

            if(player.isDead()) {

                sb.append("You lost the fight...");
                System.out.println(sb);
                player.view.handleMove(new Move(sb.toString()));
                return;
            }
            else if(monster.isDead()) {

                sb.append("You won the fight!");
                System.out.println(sb);
                player.view.handleMove(new Move(sb.toString()));
                return;
            }
            player.hit(monster);

            sb.append("You hit " + monster.getName() +  " and inflict " + player.getStrength() + " damage."); sb.append("\n\n");

            if(monster.isDead()) {

                sb.append("You won the fight!");
                System.out.println(sb);
                player.view.handleMove(new Move(sb.toString()));
                return;
            }

            else if(player.isDead()) {

                sb.append("You lost the fight...");
                System.out.println(sb);
               player.view.handleMove(new Move(sb.toString()));
                return;
            }

        }





    }





}
