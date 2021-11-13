package model;

import view.View;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    View view;
    List<Treasure> items;


    public Inventory(View view){
        this.view = view;
        this.items = new ArrayList<>();

    }

    public void addItem(Treasure item){
        items.add(item);
    }

    public void removeItem(int index){
        items.remove(index);
    }


}
