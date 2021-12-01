package model.player;

import javafx.scene.input.KeyEvent;

public class StatusController implements PlayerState{

    Player player;

    public StatusController(Player player) {
        this.player = player;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case U: player.closeStatus();
        }
    }
}
