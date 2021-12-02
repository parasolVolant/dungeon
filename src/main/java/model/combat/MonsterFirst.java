package model.combat;

import model.Move;
import model.game.Game;
import model.inventory.Inventory;
import model.player.Player;
import model.room_element.monster.Goblin;
import model.room_element.monster.Monster;

public class MonsterFirst implements CombatSystem{



    Game game;

    public MonsterFirst(Game game) {

        this.game = game;

    }

    @Override
    public void fight(Monster monster) {
        Player player = game.getPlayer();
        StringBuilder sb = new StringBuilder("A monster appeared! Fight!\n\n");

        while (true){
            monster.hit(player);

            sb.append(monster.getName() + " does " + monster.getStrength() + " damage. " +  " Your  remaining life is : "  + player.getLife()); sb.append("\n\n");

            if(player.isDead()) {

                sb.append("You lost the fight...");
                game.getView().handleMove(new Move(sb.toString()));
                return;
            }
            else if(monster.isDead()) {

                sb.append("You won the fight!");
                game.getView().handleMove(new Move(sb.toString()));
                return;
            }
            player.hit(monster);

            sb.append("You hit " + monster.getName() +  " and inflict " + player.getStrength() + " damage."); sb.append("\n\n");

            if(monster.isDead()) {

                sb.append("You won the fight!");
                game.getView().handleMove(new Move(sb.toString()));
                return;
            }

            else if(player.isDead()) {

                sb.append("You lost the fight...");
                game.getView().handleMove(new Move(sb.toString()));
                return;
            }

        }





    }





}
