package model.player;

import javafx.scene.input.KeyEvent;

public interface PlayerState {

    void handle(KeyEvent event);
}
