package model.status;

import model.player.Player;
import view.View;

public class Status {

    Player player;
    StatusState state;

    public Status(Player player) {
        this.player = player;
    }

    public void setStatus(Player player) {
        this.player = player;
    }

    public void show() {
        state.show(this);
    }

    public View getView() {
        return player.getGame().getView();
    }

    private int playerAddedStrength() {
        return player.getWeapon().getAddedStrength();
    }

    public void changeState(StatusState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Player Status \n");
        sb.append("\t")
                .append("Life : "+player.getLife()+ "/"+ player.getMaxLife())
                .append("\n\t")
                .append("Strength : "+ player.getStrength() + "(+" + playerAddedStrength() +")");
        return sb.toString();
    }
}

