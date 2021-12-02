package model.player;

import controller.AdventureController;
import controller.EndGameController;
import controller.InventoryController;
import controller.StatusController;
import model.Move;
import model.game.Game;
import model.room_element.monster.Monster;
import model.inventory.ClosedInventory;
import model.inventory.Inventory;
import model.inventory.OpenedInventory;
import model.room_element.treasure.Treasure;
import model.room_element.treasure.weapon.Fists;
import model.room_element.treasure.weapon.Weapon;
import model.status.ClosedStatus;
import model.status.OpenStatus;
import model.status.Status;
import view.View;

public class Player {
    Game game;
    View view ;
    Route route;
    Inventory inventory;
    int posX, posY;
    int life;
    int strength;
    int BASE_STRENGTH = 3;
    int MAX_LIFE = 15;
    Weapon weapon;
    Status status;



    public Player(Game game) {
        this.game = game;
        this.view = game.getView();
        inventory = new Inventory(view);
        route = new Route(this);
        posX = 0;
        posY = 0;
        weapon = new Fists();
        this.life = MAX_LIFE;
        this.strength = BASE_STRENGTH;
        status = new Status(this);
    }

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public int getMaxLife() {
        return MAX_LIFE;
    }

    public int getBaseStrength() {
        return BASE_STRENGTH;
    }


    public void setWeapon(Weapon weapon) {
        inventory.addItem(this.weapon);
        this.weapon = weapon;
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setLife(int lifeValue) {
        this.life = lifeValue;
    }

    public void setStrength(int strengthValue) {
        this.strength = strengthValue;
    }

    public void hit(Monster monster){
        monster.setLife(monster.getLife()-this.strength);
    }


    public boolean isDead() {
        if(life <= 0) {
            game.changeController(new EndGameController(game));
            return true;
        }
        return false;
    }


    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Game getGame() {
        return game;
    }


    public void goNorth() {
        if(route.isPath(posX, posY-1)) {
            posY--;
            route.update(posX, posY);
        } else {
            view.handleMove(new Move("You go North but you face a wall."));
        }
    }

    public void goSouth() {
        if(route.isPath(posX, posY+1)) {
            posY++;
            route.update(posX, posY);
        } else {
            view.handleMove(new Move("You go South but you face a wall."));
        }
    }

    public void goWest() {
        if(route.isPath(posX-1, posY)) {
            posX--;
            route.update(posX, posY);
        } else {
            view.handleMove(new Move("You go West but you face a wall."));
        }
    }

    public void goEast() {
        if(route.isPath(posX+1, posY)) {
            posX++;
            route.update(posX, posY);
        } else {
            view.handleMove(new Move("You go East but you face a wall."));
        }
    }

    public boolean isFull() {
        return inventory.isFull();
    }

    public void openInventory() {
        inventory.setIndexToStart();
        //game.changeState(new InInventoryState(game));
        //game.changeState(new InInventoryState(game));
        game.changeController(new InventoryController(game));
        inventory.changeState(new OpenedInventory());
        inventory.show();
        //view.handleMove(new Move(inventory.show()));
    }

    public void closeInventory() {
        //this.changeState(new InAdventureState(game));
        //game.changeState(new InAdventureState(game));
        game.changeController(new AdventureController(game));
        inventory.changeState(new ClosedInventory());
        inventory.show();
        //view.handleMove(new Move(inventory.show()));
    }

    public void openStatus() {
        game.changeController(new StatusController(game));
        status.setStatus(this);
        status.changeState(new OpenStatus());
        status.show();
    }

    public void closeStatus() {
        game.changeController(new AdventureController(game));
        status.changeState(new ClosedStatus());
        status.show();
    }

    public void useItem() {
        Treasure item = inventory.removeItem();
        try {
            item.equip(this);
        } catch (NullPointerException ignored) {}
        inventory.show();
    }

    public void deleteItem() {
        inventory.removeItem();
        inventory.show();
    }


}
