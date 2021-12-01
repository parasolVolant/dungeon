package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.game.Game;
import model.player.Player;

public class JavaFXController {
    EventHandler<? super KeyEvent> eventHandler;

    JavaFXController(Game game){

     eventHandler = new EventHandler<KeyEvent>() {

         @Override

         public void handle(KeyEvent event) {
             game.getPlayer().getState().handle(event);
         }
    }; }
}
