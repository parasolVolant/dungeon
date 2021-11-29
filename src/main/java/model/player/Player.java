package model.player;

import model.Move;
import model.room_element.treasure.Potion;
import model.inventory.ClosedInventory;
import model.inventory.Inventory;
import model.inventory.OpenedInventory;
import model.room_element.treasure.Treasure;
import view.View;

public class Player {
    View view ;
    Inventory inventory;
    PlayerState state;
    int posX, posY;
    Route route;

    public Player(View view) {
        this.view = view;
        inventory = new Inventory(view);
        state = new InAdventureState(this);
        posX = 0;
        posY = 0;
        route = new Route(this);
        //fakeInventory();
    }

    public Route getRoute() {
        return this.route;
    }

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

    public void useItem(int index) {
        Treasure item = inventory.removeItem(index);
        try {
            item.equip(this);
        } catch (NullPointerException ignored) {}
        inventory.show();
    }

}
