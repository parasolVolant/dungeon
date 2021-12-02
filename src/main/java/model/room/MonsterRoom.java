package model.room;

import model.Move;
import model.game.Game;
import model.player.Player;
import model.room_element.monster.Monster;
import model.room_element.monster.MonsterGenerator;

public class MonsterRoom implements Room{

    Monster monster = new MonsterGenerator().createMonster();

    @Override
    public void event(Game game) {
        game.getCombatSystem().fight(monster);

    }
}
