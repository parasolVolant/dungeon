package model.labyrinth.algo;

import model.labyrinth.graph.*;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Random;

public class AldousBroderAlgorithm {

    Graph graph;
    ArrayList<Arc> tree;
    BitSet reached;
    private static Random random = new Random();

    private AldousBroderAlgorithm(Graph graph) {
        this.graph = graph;
        this.tree = new ArrayList<>();
        this.reached = new BitSet(graph.order);
    }

    private void algorithm(int startingVertex) {
        int sommetActuel = startingVertex;
        reached.set(startingVertex);
        while (reached.cardinality() != graph.order) {
            Arc[] arcs = graph.outNeighbours(sommetActuel);
            int index = random.nextInt(arcs.length);
            Arc arcTemporaire = arcs[index];
            if (!reached.get(arcTemporaire.getDest())){
                reached.set(arcTemporaire.getDest());
                tree.add(arcTemporaire);
            }
            sommetActuel = arcTemporaire.getDest();
        }
    }
    public static ArrayList<Arc> generateTree(Graph graph, int root) {
        AldousBroderAlgorithm aldousBroderAlgorithm = new AldousBroderAlgorithm(graph);
        aldousBroderAlgorithm.algorithm(root);
        return aldousBroderAlgorithm.tree;
    }
}

