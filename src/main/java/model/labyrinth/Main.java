package model.labyrinth;
import Graph.Edge;
import model.game.Board;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Board map = new Board(50, 50);
        List<Edge> tree = map.graph();
    }

}
