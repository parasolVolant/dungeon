package model.combat;

import model.Move;
import model.game.Game;
import model.inventory.Inventory;
import model.player.Player;
import model.room_element.monster.Monster;

public class PlayerFirst implements CombatSystem{


    Player player;

    Game game;


    public PlayerFirst() {

        this.player = game.getPlayer();
    }

    @Override
    public void fight(Monster monster) {

        StringBuilder sb = new StringBuilder("A monster appeared! Fight!\n\n");

        while (!player.isDead() && !monster.isDead() ){

            player.hit(monster);

            sb.append("You hit " + monster.getName() +  " and inflict " + player.getStrength() + " damage."); sb.append("\n\n");

            if(player.isDead()) {

                sb.append("You lost the fight");
                System.out.println(sb);
                game.getView().handleMove(new Move(sb.toString()));
                return;
            }


            else if(monster.isDead()) {

                sb.append("You won the fight!");
                System.out.println(sb);
                game.getView().handleMove(new Move(sb.toString()));
                return;
            }

            monster.hit(player);

            sb.append(monster.getName() + " does " + monster.getStrength() + " damage. " +  " Your  remaining life is : "  + player.getLife()); sb.append("\n\n");


            if(monster.isDead()){

                sb.append("You won the fight");
                System.out.println(sb);
                game.getView().handleMove(new Move(sb.toString()));
                return;

            }

            else if(player.isDead()) {

                sb.append("You lost the fight");
                System.out.println(sb);
                game.getView().handleMove(new Move(sb.toString()));
                return;

            }

        }


    }
}