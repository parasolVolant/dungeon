package model.labyrinth;
import model.player.Route;
import model.labyrinth.Graph.*;
import model.player.Player;
import view.JavaFXView;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /*
        Edge edge = new Edge(0,1,1);
        Edge edge2 = new Edge(1, 2, 1);
        Arc arc1 = new Arc(edge, false);
        Arc arc2 = new Arc(edge2, false);

        CoverTree tree = new CoverTree(50, 50);
        Grid grid = tree.getGrid();
        List<Edge> graph = tree.getGraph();
        */


        Route route = new Route(new Player(new JavaFXView()));
        Player player = new Player(new JavaFXView(), route);
        Edge contained = route.getGraph().get(0);
/*
        List<Edge> graph = route.getGraph();
        int[] notContained = randomNotContainedEdge(graph);
        System.out.println(route.isPath(contained));
        System.out.println(route.isPath(notContained[0], notContained[1]));*/
    }

    public static int[] randomNotContainedEdge(List<Edge> graph) {
        Random rand = new Random();
        Edge edge = null;
        int[] coord = new int[2];
        int source, dest;
        while(true) {
            source = rand.nextInt(50);
            dest = rand.nextInt(50);
            edge = new Edge(source, dest, 1);
            if (!graph.contains(edge)) break;
        }
        coord[0] = source;
        coord[1] = dest;
        return coord;
    }

}
