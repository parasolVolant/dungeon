package RandomTreeAlgos;

import Graph.Graph;
import Graph.Arc;

import java.util.*;

public class RandomizedWidthCourse {

    Graph graph;
    ArrayList<Arc> tree;
    Stack<Integer> stack ;
    BitSet visited;

    public RandomizedWidthCourse(Graph graph) {
        this.graph = graph;
        this.tree = new ArrayList<>();
        this.stack = new Stack<>();
        this.visited =new BitSet(graph.order+1);
    }

    public void randomBFS(int vertex){
        visited.set(vertex, true);
        stack.push(vertex);
        while (!stack.isEmpty()){
            int currentCell = stack.pop();
            List<Arc> adjacency = graph.out1Neighbours(currentCell);
            Collections.shuffle((adjacency));
            for(Arc arc : adjacency){
                if (!visited.get(arc.getDest())){
                    stack.push(currentCell);
                    visited.set(arc.getDest(), true);
                    tree.add(arc);
                    stack.push(arc.getDest());
                }
            }

        }
    }

    public static ArrayList<Arc> generateTree(Graph graph, int source) {
        RandomizedWidthCourse bfs = new RandomizedWidthCourse(graph);
        bfs.randomBFS(source);
        return bfs.tree;
    }
}

