package model.inventory;

import model.roomElement.treasure.Treasure;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Treasure> items;
    InventoryState state;
    View view;
    int maxSize;

    public Inventory(View view) {
        maxSize = 5;
        this.items = new ArrayList<>();
        this.state = new ClosedInventory();
        this.view = view;
    }

    public void changeState(InventoryState newState) {
        state = newState;
    }

    public void addItem(Treasure item){
        if(items.size() >= maxSize) return;
        items.add(item);
    }

    public Treasure removeItem(int index) {
        if (index >= items.size()) return null;
        Treasure item = items.get(index);
        items.remove(index);
        return item;
    }

    public void show() {
        state.show(this);
    }

}
