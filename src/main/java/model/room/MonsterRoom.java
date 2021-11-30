package model.room;

import model.Move;
import model.player.Player;
import model.room_element.monster.Monster;
import model.room_element.monster.MonsterGenerator;

public class MonsterRoom implements Room{

    Monster monster = new MonsterGenerator().createMonster();

    @Override
    public void event(Player player) {
        System.out.println("sltatouslesamis");
        player.getCombatSystem().fight(monster);
        System.out.println("miss jirachi");
        //player.getView().handleMove(new Move("test"));
        //TODO
    }
}
