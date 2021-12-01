package model.game;

import model.combat.CombatSystem;
import model.combat.MonsterFirst;
import model.player.Player;
import model.player.Route;
import view.View;

public class Game {



    private int width;
    private int height;
    private Player player;
    private CombatSystem combatSystem;
    //private GameController gameController;
    private View view;


    public Game(int width,int height,View view,CombatSystem combatSystem){
        this.width = width;
        this.height = height;
        this.combatSystem = combatSystem;
        //gameController = new AdventureController(this);
        this.view = view;
        this.player = new Player(this);


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

    /*public GameController getController() {
        return gameController;
    }


    public void changeController(GameController controller) {
        gameController = controller;
    }*/



}
