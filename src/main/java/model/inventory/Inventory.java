package model.inventory;

import model.Treasure;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Treasure> items;
    InventoryState state;
    View view;

    public Inventory(View view) {
        this.items = new ArrayList<>();
        this.state = new ClosedInventory();
        this.view = view;
    }

    public void changeState(InventoryState newState) {
        state = newState;
    }

    public void addItem(Treasure item){
        items.add(item);
    }

    public void removeItem(int index){
        items.remove(index);
    }

    public void show() {
        state.show(this);
    }

}
