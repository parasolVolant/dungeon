package model.player;

import javafx.scene.input.KeyEvent;
import model.Move;

public class DeadState implements PlayerState{

    Player player;

    public DeadState(Player player) {
        this.player = player;
    }

    @Override
    public void handle(KeyEvent event) {
        Move move = new Move("You lost.");
        switch (event.getCode()) {
            default : player.getView().handleMove(move);
        }
    }
}
