package model.player;

import model.Move;
import model.Potion;
import model.inventory.ClosedInventory;
import model.inventory.Inventory;
import model.inventory.OpenedInventory;
import view.View;

public class Player {
    View view ;
    Inventory inventory;
    PlayerState state;

    int health;
    int strength;
    int maxHealth = 10;

    public Player(View view) {
        this.view = view;
        inventory = new Inventory(view);
        state = new InAdventureState(this);
        fakeInventory();
    }

    private void fakeInventory() {
        for (int i = 0; i < 5; i++) {
            inventory.addItem(new Potion());
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public PlayerState getState() {
        return state;
    }

    public void goNorth() {
        view.handleMove(new Move("You face a wall."));
    }

    public void goSouth() {
        view.handleMove(new Move("You face the Golden wind."));
    }

    public void goWest() {
        view.handleMove(new Move("You face the Western wind."));
    }

    public void goEast() {
        view.handleMove(new Move("You face the Eastern wind."));
    }

    public void changeState(PlayerState newState) {
        state = newState;
    }

    public void openInventory() {
        this.changeState(new InInventoryState(this));
        inventory.changeState(new OpenedInventory());
        inventory.show();
        //view.handleMove(new Move(inventory.show()));
    }

    public void useItem(int index) {
        inventory.removeItem(index);
        String itemName = inventory.getItem(index).getName();
        view.handleMove(new Move("You used a " + itemName + "."));
    }

    public void closeInventory() {
        this.changeState(new InAdventureState(this));
        inventory.changeState(new ClosedInventory());
        inventory.show();
        //view.handleMove(new Move(inventory.show()));
    }
}
