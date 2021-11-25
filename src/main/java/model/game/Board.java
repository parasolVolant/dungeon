package model.game;

import Graph.*;
import GraphClasses.*;
import GraphClasses.Grid;
import model.labyrinth.RandomTreeAlgos.AldousBroderAlgorithm;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;


public class Board {

    @SuppressWarnings("unused")
    private final static Random gen = new Random();

    Grid grid;

    public Board(int width, int height) {
        grid = new Grid(width, height);
    }

    public ArrayList<Edge> graph() throws InterruptedException {

        //grid = new Grid(1920 / 11, 1080 / 11);
        Graph graph = grid.graph;

        ArrayList<Edge> randomTree = genTree(graph);

        showGrid(grid, randomTree);

        return randomTree;
    }

    public static ArrayList<Edge> genTree(Graph graph) {
        ArrayList<Edge> randomTree;

        // Non-random BFS
        ArrayList<Arc> randomArcTree = AldousBroderAlgorithm.generateTree(graph, 0);

        randomTree = new ArrayList<>();
        for (Arc a : randomArcTree) randomTree.add(a.support);
        return randomTree;
    }

    private static void showGrid(
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

