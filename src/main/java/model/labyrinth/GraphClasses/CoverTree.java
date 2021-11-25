package model.labyrinth.GraphClasses;

import model.labyrinth.Graph.*;
import model.labyrinth.GraphClasses.*;
import model.labyrinth.RandomTreeAlgos.AldousBroderAlgorithm;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;


public class CoverTree {

    @SuppressWarnings("unused")
    private final static Random gen = new Random();

    Grid grid;
    ArrayList<Edge> graph = new ArrayList<Edge>();

    public CoverTree(int width, int height) {
        grid = new Grid(width, height);
        try {
            graph = graph();
        } catch (InterruptedException e) { }
    }

    public ArrayList<Edge> getGraph() {
        return graph;
    }

    public Grid getGrid() {
        return grid;
    }

    public ArrayList<Edge> graph() throws InterruptedException {
        Graph graph = grid.graph;

        ArrayList<Edge> randomTree = genTree(graph);

        showGrid(grid, randomTree);

        return randomTree;
    }

    public boolean isPath(int sourceRow, int sourceCol, int destRow, int destCol) {
        int source = grid.vertexOfCoordinate(sourceRow, sourceCol);
        int dest = grid.vertexOfCoordinate(destRow, destCol);
        Edge edge = new Edge(source, dest, 1);
        return graph.contains(edge);
    }

    private ArrayList<Edge> genTree(Graph graph) {
        ArrayList<Edge> randomTree;

        // Non-random BFS
        ArrayList<Arc> randomArcTree = AldousBroderAlgorithm.generateTree(graph, 0);

        randomTree = new ArrayList<>();
        for (Arc a : randomArcTree) randomTree.add(a.support);
        return randomTree;
    }

    public void showGrid(
            Grid grid,
            ArrayList<Edge> randomTree
    ) throws InterruptedException {
        RootedTree rooted = new RootedTree(randomTree, 0);

        JFrame window = new JFrame("solution");
        final Labyrinth laby = new Labyrinth(grid, rooted);


        laby.setStyleBalanced();
//		laby.setShapeBigNodes();
//		laby.setShapeSmallAndFull();
        laby.setShapeSmoothSmallNodes();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(laby);
        window.pack();
        window.setLocationRelativeTo(null);


        for (final Edge e : randomTree) {
            laby.addEdge(e);
        }
        laby.drawLabyrinth();

        window.setVisible(true);

        // Pour générer un fichier image.
        try {
            laby.saveImage("resources/random.png");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

}

