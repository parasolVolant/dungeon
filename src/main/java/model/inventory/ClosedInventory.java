package model.inventory;

import model.Move;

public class ClosedInventory implements InventoryState{

    @Override
    public void show(Inventory inventory) {
        inventory.view.handleMove(new Move("You closed the inventory."));
    }
}
