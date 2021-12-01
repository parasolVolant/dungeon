package model.game;

import controller.AdventureController;
import controller.GameController;
import model.combat.CombatSystem;
import model.combat.MonsterFirst;
import model.player.Player;
import model.player.Route;
import view.JavaFXView;
import view.View;

public class Game {

    private int width = 10;
    private int height = 10;
    private Player player;
    private Route route;
    private CombatSystem combatSystem;
    private GameController gameController;
    private View view;








    public Game(int width,int height,View view){
        this.width = width;
        this.height = height;
        this.combatSystem = new MonsterFirst(this);
        gameController = new AdventureController(this);
        this.view = view;
        this.player = new Player();
        this.route = new Route(this);
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

    public Route getRoute(){
        return route;
    }

    public CombatSystem getCombatSystem(){
        return combatSystem;
    }

    public GameController getController() {
        return gameController;
    }


    public void changeController(GameController controller) {
        gameController = controller;
    }

}
