package model.player;

import controller.GameController;
import controller.AdventureController;
import controller.InventoryController;
import model.Move;
import model.game.Game;
import model.room_element.monster.Monster;
import model.inventory.ClosedInventory;
import model.inventory.Inventory;
import model.inventory.OpenedInventory;
import model.room_element.treasure.Treasure;

public class Player {

    Game game;
    Inventory inventory;
    //GameController controller;
    int posX, posY;
    int life;
    int strength;
    int MAX_LIFE = 15;



    public Player() {

        game = new Game(game.getWidth(),game.getHeight(),game.getView());
        inventory = new Inventory(game.getView());
        posX = 0;
        posY = 0;
        this.life = MAX_LIFE;
        this.strength = 5;

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

    public void hit(Monster monster){
        System.out.println("tu tapes le monstre ma belle");
        monster.setLife(monster.getLife()-this.strength);
        System.out.println(monster.getLife());
    }


    public boolean isDead() { return life <= 0; }



    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Inventory getInventory() {
        return inventory;
    }


    /*public GameController getController() {
        return controller;
    }

    public void changeState(GameController newState) {
        controller = newState;
    }*/


    public void goNorth() {
        if(game.getRoute().isPath(posX, posY-1)) {
            posY--;
            game.getRoute().update(posX, posY);
        } else {
            game.getView().handleMove(new Move("You go North but you face a wall."));
        }
    }

    public void goSouth() {
        if(game.getRoute().isPath(posX, posY+1)) {
            posY++;
            game.getRoute().update(posX, posY);
        } else {
            game.getView().handleMove(new Move("You go South but you face a wall."));
        }
    }

    public void goWest() {
        if(game.getRoute().isPath(posX-1, posY)) {
            posX--;
            game.getRoute().update(posX, posY);
        } else {
            game.getView().handleMove(new Move("You go West but you face a wall."));
        }
    }

    public void goEast() {
        if(game.getRoute().isPath(posX+1, posY)) {
            posX++;
            game.getRoute().update(posX, posY);
        } else {
            game.getView().handleMove(new Move("You go East but you face a wall."));
        }
    }

    public boolean isFull() {
        return inventory.isFull();
    }

    public void openInventory() {
        game.changeController(new InventoryController(game));
        inventory.changeState(new OpenedInventory());
        inventory.show();
        //view.handleMove(new Move(inventory.show()));
    }

    public void closeInventory() {
        game.changeController(new AdventureController(game));
        inventory.changeState(new ClosedInventory());
        inventory.show();
        //view.handleMove(new Move(inventory.show()));
    }

    public void useItem(int index) {
        Treasure item = inventory.removeItem(index);
        try {
            item.equip(this);
        } catch (NullPointerException ignored) {}
        inventory.show();
    }

}
