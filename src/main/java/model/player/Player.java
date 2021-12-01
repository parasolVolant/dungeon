package model.player;

import model.Move;
import model.combat.CombatSystem;
import model.combat.MonsterFirst;
import model.combat.PlayerFirst;
import model.room_element.monster.Monster;
import model.room_element.treasure.Potion;
import model.inventory.ClosedInventory;
import model.inventory.Inventory;
import model.inventory.OpenedInventory;
import model.room_element.treasure.Treasure;
import model.room_element.treasure.weapon.Fists;
import model.room_element.treasure.weapon.Sword;
import model.room_element.treasure.weapon.Weapon;
import view.View;

public class Player {
    View view ;
    Inventory inventory;
    PlayerState state;
    int posX, posY;
    Route route;
    int life;
    int strength;
    int BASE_STRENGTH = 3;
    int MAX_LIFE = 15;
    Weapon weapon;
    CombatSystem combatSystem;


    public Player(View view) {
        this.view = view;
        inventory = new Inventory(view);
        state = new InAdventureState(this);
        posX = 0;
        posY = 0;
        route = new Route(this);
        this.life = MAX_LIFE;
        this.strength = BASE_STRENGTH;
        weapon = new Fists();
        this.combatSystem = new MonsterFirst(this);
    }

    public int getLife() {
        return life;
    }

    public int getMaxLife() {
        return MAX_LIFE;
    }

    public int getStrength() {
        return strength;
    }

    public int getBaseStrength() {
        return BASE_STRENGTH;
    }

    public void setWeapon(Weapon weapon) {
        inventory.addItem(this.weapon);
        this.weapon = weapon;
    }

    public CombatSystem getCombatSystem() {
        return combatSystem;
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

    public View getView() {
        return view;
    }

    public PlayerState getState() {
        return state;
    }

    public void changeState(PlayerState newState) {
        state = newState;
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
