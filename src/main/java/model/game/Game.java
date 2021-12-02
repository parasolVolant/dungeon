package model.game;

import controller.AdventureController;
import controller.GameController;
import model.combat.CombatSystem;
import model.combat.MonsterFirst;
import model.player.Player;
import view.View;

public class Game {



    private int width;
    private int height;
    private Player player;
    private CombatSystem combatSystem;
    private GameController gameController;
    private View view;


    public Game(int width,int height,View view){
        this.width = width;
        this.height = height;
        this.view = view;
        this.player = new Player(this);
        this.combatSystem = new MonsterFirst(this);
        gameController = new AdventureController(this);



    }


    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }


    public Player getPlayer(){
        return player;
    }

    public View getView(){
        return view;
    }


   public CombatSystem getCombatSystem(){
        return combatSystem;
    }

    public GameController getController() {
        return gameController;
    }

    public void changeController(GameController newController) {
        gameController = newController;
    }




}
