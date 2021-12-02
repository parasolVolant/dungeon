package model.inventory;

import model.Move;
import model.room_element.treasure.Treasure;

import java.util.List;

public class OpenedInventory implements InventoryState {

    @Override
    public void show(Inventory inventory) {
        inventory.view.handleMove(new Move(asString(inventory)));
    }

    private String asString(Inventory inventory) {
        List<Treasure> items = inventory.items;
        int size = inventory.items.size();
        int maxSize = inventory.maxSize;
        int inventoryIndex = inventory.index;

        StringBuilder sb = new StringBuilder("Inventory " + size +"/"+maxSize+" :  \n");
        for (int i = 0; i < items.size(); i++) {
            sb.append("\t");

            if (i == inventoryIndex) {
                sb.append("-> ");
            }

            sb.append(" - ")
                    .append(items.get(i).getName())
                    .append("\n");
        }
        return sb.toString();
    }
}







