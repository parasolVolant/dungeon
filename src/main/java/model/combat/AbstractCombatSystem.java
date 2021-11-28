package model.combat;

import model.player.Player;
import model.roomElement.monster.Monster;

public abstract class AbstractCombatSystem implements CombatSystem {

    Player player;
    protected StringBuilder sb;
    static final String VICTORY = "You won the fight";
    static final String DEFEAT = "You won the fight";


    public AbstractCombatSystem(Player player){
        this.player = player;

    }




    public abstract void fight(Monster monster);
}
