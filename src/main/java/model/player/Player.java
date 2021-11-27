package model.player;

import model.Move;
import model.roomElement.treasure.Potion;
import model.inventory.ClosedInventory;
import model.inventory.Inventory;
import model.inventory.OpenedInventory;
import model.roomElement.treasure.Treasure;
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
        fakeInventory();
    }

    public Player(View view, Route route) {
        this.view = view;
        inventory = new Inventory(view);
        state = new InAdventureState(this);
        posX = 0;
        posY = 0;
        this.route = route;
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

    public void useItem(int index) {
        Treasure item = inventory.removeItem(index);
        try {
            System.out.println(item.getName());
        } catch (NullPointerException ignored) {}
        inventory.show();
    }

}
