package model.game;

import model.roomElement.RoomElement;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGenerator implements Generator{

    List<RoomElement> elements = new ArrayList<>();

    @Override
    public abstract RoomElement generate();

    public void addElement(RoomElement element){
        elements.add(element);
    }

    public void removeElement(RoomElement element){
        elements.remove(element);
    }


}
