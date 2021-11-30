package model.player;

import javafx.geometry.Point2D;
import model.Move;
import model.combat.CombatSystem;
import model.combat.MonsterFirst;
import model.combat.PlayerFirst;
import model.game.Route;
import model.roomElement.monster.Monster;
import model.roomElement.treasure.Potion;
import model.inventory.ClosedInventory;
import model.inventory.Inventory;
import model.inventory.OpenedInventory;
import view.View;

import javax.swing.text.Position;

public class Player {
    public View view ;
    Inventory inventory;
    PlayerState state;
    int posX, posY;
    Route route;
    private int life;
    private int strength;
    public final int MAX_LIFE = 15;
    public CombatSystem combatSystem;


    public Player(View view) {
        this.view = view;
        inventory = new Inventory(view);
        state = new InAdventureState(this);
        posX = 0;
        posY = 0;
        route = new Route(this);
        fakeInventory();
        this.life = MAX_LIFE;
        this.strength = 5;
        this.combatSystem = new PlayerFirst(this);
    }





    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public void setLife(int lifeValue) {
        this.life = lifeValue;
    }

    public void setStrength(int strengthValue) {
        this.strength = strengthValue;
    }

    public Route getRoute() {
        return this.route;
    }

    public void hit(Monster monster){
        monster.setLife(monster.getLife()-this.getStrength());
    }


    public boolean isDead() { return life <= 0; }


    private void fakeInventory() {
        for (int i = 0; i < 5; i++) {
            inventory.addItem(new Potion());
        }

    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public PlayerState getState() {
        return state;
    }

    public void changeState(PlayerState newState) {
        state = newState;
    }


    public void goNorth() {
        System.out.println(route.isPath(posX, posY-1));
        if(route.isPath(posX, posY-1)) {
            view.handleMove(new Move("You go North."));
            posY--;
        } else {
            view.handleMove(new Move("You face a wall"));
        }
    }

    public void goSouth() {
        int roomY = posY+1;
        System.out.println(route.isPath(posX, roomY));
        if(route.isPath(posX, roomY)) {
            view.handleMove(new Move("You go South."));
            posY++;
            System.out.println("ton papa");
        } else {
            System.out.println("ta maman");
            view.handleMove(new Move("You face a wall"));
        }
    }

    public void goWest() {
        if(route.isPath(posX-1, posY)) {
            view.handleMove(new Move("You go West."));
            posX--;
        } else {
            view.handleMove(new Move("You face a wall"));
        }
    }

    public void goEast() {
        if(route.isPath(posX+1, posY)) {
            view.handleMove(new Move("You go East."));
            posX++;
        } else {
            view.handleMove(new Move("You face a wall"));
        }
    }


    public void openInventory() {
        this.changeState(new InInventoryState(this));
        inventory.changeState(new OpenedInventory());
        inventory.show();
        //view.handleMove(new Move(inventory.show()));
    }

    public void closeInventory() {
        this.changeState(new InAdventureState(this));
        inventory.changeState(new ClosedInventory());
        inventory.show();
        //view.handleMove(new Move(inventory.show()));
    }






}
