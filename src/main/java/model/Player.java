package model;

import model.inventory.ClosedInventory;
import model.inventory.Inventory;
import model.inventory.OpenedInventory;
import view.View;

public class Player {
    View view ;
    Inventory inventory;

    public Player(View view) {
        this.view = view;
        inventory = new Inventory(view, new ClosedInventory());
        fakeInventory();
    }

    private void fakeInventory() {
        for (int i = 0; i < 5; i++) {
            inventory.addItem(new Potion());
        }
    }

    public void goNorth() {
        view.handleMove(new Move("You face a wall"));
    }

    public void openInventory() {
        inventory.changeState(new OpenedInventory());
        inventory.show();
        //view.handleMove(new Move(inventory.show()));
    }

    public void closeInventory() {
        inventory.changeState(new ClosedInventory());
        inventory.show();
        //view.handleMove(new Move(inventory.show()));
    }
}
