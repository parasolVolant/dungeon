package model;

import model.player.Player;

public class Potion implements Treasure{
    @Override
    public String getName() {
        return "Potion";
    }

    @Override
    public void equip(Player player) {

    }
}
