package model.inventory;

import model.Move;
import model.roomElement.treasure.Treasure;

import java.util.List;

public class OpenedInventory implements InventoryState {

    @Override
    public void show(Inventory inventory) {
        inventory.view.handleMove(new Move(asString(inventory)));
    }

    private String asString(Inventory inventory) {
        List<Treasure> items = inventory.items;
        StringBuilder sb = new StringBuilder("Inventory \n");
        for (int i = 0; i < items.size(); i++) {
            sb.append("\t" + i + " - " + items.get(i).getName() + "\n");
        }
        return sb.toString();
    }
}
