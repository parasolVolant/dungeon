package model.game;

import model.roomElement.RoomElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {


    int row;
    int column;
    List<RoomElement> elements = new ArrayList<>();

    /*
    0 -> hasTreasure | 1-> hasMonster | 2-> hasTrap
     */

    boolean[] hasElements = new boolean[3];

    public Room(int row, int column){
        this.row = row;
        this.column = column;
        initElements();
        initRoom();
    }

    private void initElements() {
        Random random = new Random();
        for (int i = 0; i <3 ; i++) {
            hasElements[i] = true;
        }
        //TODO
        //remplir la liste des éléments de la salle
    }

    private void initRoom(){
        if(hasTreasure()) generateElement(new TreasureGenerator());
        if (hasMonster()) generateElement(new MonsterGenerator());
        if (hasTrap()) generateElement(new TrapGenerator());
    }


    public void emptyRoom() {
        hasElements = new boolean[3];
    }

    public boolean hasTreasure(){
        return hasElements[0];
    }


    public boolean hasMonster(){
        return hasElements[1];
    }


    public boolean hasTrap(){
        return hasElements[2];
    }


    private void generateElement(Generator generator) {
        elements.add(generator.generate());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(RoomElement element : elements) {
            sb.append(element.getName());
        }
        return sb.toString();
    }
}
