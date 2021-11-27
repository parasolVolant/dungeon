package model.room;

import model.Move;
import model.player.Player;
import model.roomElement.monster.Monster;
import model.roomElement.monster.MonsterGenerator;

public class MonsterRoom implements Room{

    Monster monster = new MonsterGenerator().createMonster();

    @Override
    public void event(Player player) {
        player.getView().handleMove(new Move(
                "A monster appeared! " + monster.getString()
        ));
        //TODO
    }
}
