package RandomTreeAlgos;

import Graph.Graph;
import Graph.Edge;
import Graph.Arc;

import java.util.*;


public class RandomPrim {
    Graph graph;
    ArrayList<Arc> tree;
    public RandomPrim(Graph graph) {
        this.graph = graph;
        tree = new ArrayList<>();
    }

    private Graph assignWeight(Graph graph){
        for (int i = 0; i < graph.order; i++) {
            for (Edge edge: graph.neighbours(i)) {
                edge.setWeight(Math.random());
            }
        }
        return graph;
    }
    public void randomPrim(int startVertex) {
        BitSet visited = new BitSet();
        PriorityQueue<Edge> cut = new PriorityQueue<>();
        // Random rnd = new Random();
        expand(graph, startVertex, cut, visited);
        while (!cut.isEmpty()) {
            Edge edge = cut.poll();
            int u = edge.source, v = edge.dest;
            if (!visited.get(u) || !visited.get(v)) {
                tree.add(new Arc(edge,false));
                    expand(graph, !visited.get(u) ? u : v, cut, visited);
            }
        }
    }
    private  void expand(Graph graph, int vertex, PriorityQueue<Edge> cut, BitSet visited) {
        visited.set(vertex);
        for (Edge edge: graph.neighbours(vertex)) {
            if (!visited.get(edge.dest)){
                //attribuer à chaque arête un poids réel choisi dans[0,1]uniformément aléatoirement
                Edge edge1 = new Edge(edge.source,edge.dest, Math.random());
                cut.add(edge1);
            }
        }
    }

    public static ArrayList<Arc> generateTree(Graph graph, int root) {
        RandomPrim algo = new RandomPrim(graph);
        algo.randomPrim(root);
        return algo.tree;
    }

}

