package model.player;

import javafx.geometry.Point2D;
import model.Move;
import model.roomElement.treasure.Potion;
import model.inventory.ClosedInventory;
import model.inventory.Inventory;
import model.inventory.OpenedInventory;
import view.View;

import javax.swing.text.Position;

public class Player {
    View view ;
    Inventory inventory;
    PlayerState state;
    Point2D position;

    public Player(View view) {
        this.view = view;
        inventory = new Inventory(view);
        state = new InAdventureState(this);
        position = new Point2D(0,0);
        fakeInventory();
    }

    private void fakeInventory() {
        for (int i = 0; i < 5; i++) {
            inventory.addItem(new Potion());
        }
    }

    public PlayerState getState() {
        return state;
    }

    public void goNorth() {
        view.handleMove(new Move("You face a wall"));
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

    public void closeInventory() {
        this.changeState(new InAdventureState(this));
        inventory.changeState(new ClosedInventory());
        inventory.show();
        //view.handleMove(new Move(inventory.show()));
    }
}
