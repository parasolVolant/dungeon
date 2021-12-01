package model.player;

import javafx.scene.input.KeyEvent;

public class EndGameState implements PlayerState{

    Player player;

    public EndGameState(Player player) {
        this.player = player;
    }

    @Override
    public void handle(KeyEvent event) {}
}
