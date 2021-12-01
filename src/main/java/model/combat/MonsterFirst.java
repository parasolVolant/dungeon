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
        System.out.println("c david lafarge pokemon");

        StringBuilder sb = new StringBuilder("A monster appeared! Fight!\n\n");

        while (true){

            System.out.println("ojord'hui on va tester des cartes");

            monster.hit(player);

            sb.append(monster.getName() + " does " + monster.getStrength() + " damage. " +  " Your  remaining life is : "  + player.getLife()); sb.append("\n\n");

            if(player.isDead()) {

                sb.append("You lost the fight...");
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
            player.hit(monster);

            sb.append("You hit " + monster.getName() +  " and inflict " + player.getStrength() + " damage."); sb.append("\n\n");

            if(monster.isDead()) {

                sb.append("You won the fight!");
                System.out.println(sb);
                game.getView().handleMove(new Move(sb.toString()));
                return;
            }

            else if(player.isDead()) {

                sb.append("You lost the fight...");
                System.out.println(sb);
                game.getView().handleMove(new Move(sb.toString()));
                return;
            }

        }


        //System.out.println("et je suis en compagnie de");


    }





}
