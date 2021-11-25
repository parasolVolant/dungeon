package model.labyrinth;
import model.labyrinth.Graph.*;
import model.game.Route;
import model.labyrinth.GraphClasses.CoverTree;
import model.labyrinth.GraphClasses.Grid;
import model.player.Player;
import view.ConsoleView;
import view.JavaFXView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //
        //List<Edge> tree = map.graph();
        Edge edge = new Edge(0,1,1);
        Edge edge2 = new Edge(1, 2, 1);
        Arc arc1 = new Arc(edge, false);
        Arc arc2 = new Arc(edge2, false);

        CoverTree tree = new CoverTree(50, 50);
        Grid grid = tree.getGrid();
        ArrayList<Edge> graph = tree.getGraph();
        tree.showGrid(grid, graph);
        tree.showGrid(grid, graph);
        //Route route = new Route(new Player(new JavaFXView()));
    }

}
