package controller;

import model.player.Player;
import view.ConsoleView;

import java.util.Scanner;

public class KeyBoardController {

    public void read() {
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("enter your move");
            switch (scanner.next()) {

                case "z":
                    player.goNorth();
                    break;
                case "i":

            }

        }
    }
}
