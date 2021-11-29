package model.labyrinth.graph_classes;

import model.labyrinth.graph.*;
import model.labyrinth.algo.AldousBroderAlgorithm;


import java.util.ArrayList;
import java.util.Random;


public class CoverTree {

    @SuppressWarnings("unused")
    private final static Random gen = new Random();

    Grid grid;
    ArrayList<Edge> graph = new ArrayList<Edge>();

    public CoverTree(int width, int height) {
        grid = new Grid(width, height);
        try {
            graph = graph();
        } catch (InterruptedException e) {
        }
        grid.drawSubgrid(graph);
    }

    public ArrayList<Edge> getGraph() {
        return graph;
    }

    public Grid getGrid() {
        return grid;
    }

    private ArrayList<Edge> graph() throws InterruptedException {
        Graph graph = grid.graph;

        ArrayList<Edge> randomTree = genTree(graph);

        //showGrid(grid, randomTree);

        return randomTree;
    }

    public boolean isPath(int sourceRow, int sourceCol, int destRow, int destCol) {

        int vertexOfSource = grid.vertexOfCoordinate(sourceRow, sourceCol);
        int vertexOfDest = grid.vertexOfCoordinate(destRow, destCol);

        Edge edge = new Edge(
                vertexOfSource,
                vertexOfDest,
                0.0
        );

        Edge inverseEdge = new Edge(
                vertexOfDest,
                vertexOfSource,
                0.0
        );

        return graph.contains(edge) || graph.contains(inverseEdge);
    }

    public boolean isPath(Edge edge) {
        return graph.contains(edge);
    }

    private ArrayList<Edge> genTree(Graph graph) {
        ArrayList<Edge> randomTree =  new ArrayList<>();;

        // Non-random BFS
        ArrayList<Arc> randomArcTree = AldousBroderAlgorithm.generateTree(graph, 0);

        for (Arc a : randomArcTree) randomTree.add(a.support);
        return randomTree;
    }
/*
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

    }*/

}

