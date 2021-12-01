package model.inventory;

import model.room_element.treasure.Treasure;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Treasure> items;
    InventoryState state;
    View view;
    int maxSize;
    int index;

    public Inventory(View view) {
        maxSize = 5;
        items = new ArrayList<>();
        state = new ClosedInventory();
        this.view = view;
        index = 0;
    }

    public boolean isFull() {
        return items.size() >= maxSize;
    }

    public void changeState(InventoryState newState) {
        state = newState;
    }

    public void setIndexToStart() {
        this.index = 0;
    }

    public void decreaseIndex() {
        if(items.isEmpty()) return;
        if(index <= 0) {
            index = items.size()-1;
        } else {
            index--;
        }
        //index =  ((index - 1) % (maxSize) + maxSize) % maxSize;
        show();
    }

    public void increaseIndex() {
        if(items.isEmpty()) return;
        index =  (index + 1) % items.size();
        show();
    }

    public void addItem(Treasure item){
        if(isFull()) return;
        items.add(item);
    }

    public Treasure removeItem() {
        if (index >= items.size()) return null;
        Treasure item = items.get(index);
        items.remove(index);
        decreaseIndex();
        return item;
    }

    public void show() {
        state.show(this);
    }

}





/*package model.inventory;

import model.room_element.treasure.Treasure;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Treasure> items;
    InventoryState state;
    View view;
    int maxSize;
    int index;

    public Inventory(View view) {
        maxSize = 5;
        items = new ArrayList<>();
        state = new ClosedInventory();
        this.view = view;
        index = 0;
    }

    public boolean isFull() {
        return items.size() >= maxSize;
    }

    public void changeState(InventoryState newState) {
        state = newState;
    }

    public void setIndexToStart() {
        this.index = 0;
    }

    public void decreaseIndex() {
        if(items.isEmpty()) return;
        if(index <= 0) {
            index = items.size()-1;
        } else {
            index--;
        }
        //index =  ((index - 1) % (maxSize) + maxSize) % maxSize;
        System.out.println(index);
        show();
    }

    public void increaseIndex() {
        if(items.isEmpty()) return;
        index =  (index + 1) % items.size();
        System.out.println(index);
        show();
    }

    public void addItem(Treasure item){
        if(isFull()) return;
        items.add(item);
    }

    public Treasure removeItem() {
        if (index >= items.size()) return null;
        Treasure item = items.get(index);
        items.remove(index);
        decreaseIndex();
        return item;
    }

    public void show() {
        state.show(this);
    }

}*/
