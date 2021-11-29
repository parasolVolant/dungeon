package model.labyrinth.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Graph {
    // classe de graphe non orientés permettant de manipuler
    // en même temps des arcs (orientés)
    // pour pouvoir stocker un arbre couvrant, en plus du graphe

    public int order;
    int edgeCardinality;

    ArrayList<LinkedList<Edge>> adjacency;
    ArrayList<LinkedList<Arc>> inAdjacency;
    ArrayList<LinkedList<Arc>> outAdjacency;

    public <T> ArrayList<LinkedList<T>> makeList(int size) {
        ArrayList<LinkedList<T>> res = new ArrayList<>(size);
        for(int i = 0; i <= size; i++) {
            res.add(null);
        }
        return res;
    }

    public Graph(int upperBound) {

        this.order = 0;
        this.adjacency = makeList(upperBound);
        this.inAdjacency = makeList(upperBound);
        this.outAdjacency = makeList(upperBound);
    }



    public boolean isVertex(int index) {

        if (adjacency.size() > index && adjacency.get(index) != null)
            return true;
        return false;
    }

    public void addVertex(int indexVertex) {

        if (!isVertex(indexVertex)) {
            adjacency.set(indexVertex, new LinkedList<Edge>());
            inAdjacency.set(indexVertex, new LinkedList<Arc>());
            outAdjacency.set(indexVertex, new LinkedList<Arc>());
            order++;
        }
    }

    public void ensureVertex(int indexVertex) {
        // à remplir
        if (!isVertex(indexVertex)) addVertex(indexVertex);
    }

    public void addArc(Arc arc) {

        outAdjacency.get(arc.getSource()).add(arc);
        inAdjacency.get(arc.getDest()).add(arc);
    }

    public void addEdge(Edge e) {

        ensureVertex(e.dest);
        ensureVertex(e.source);
        adjacency.get(e.dest).add(e);
        adjacency.get(e.source).add(e);

        addArc(new Arc(e,false));
        addArc(new Arc(e,true));
    }

     public List out1Neighbours(int vertex) {
       return this.outAdjacency.get(vertex);
    }

    public Arc[] outNeighbours(int sommet) {
        // à remplir
        return outAdjacency.get(sommet).toArray(new Arc[0]);
    }
    public List<Edge> neighbours(int vertex) {
        return this.adjacency.get(vertex);
    }

    public boolean isEdge(Edge e) {
        return this.adjacency.get(e.dest).contains(e);
    }

    public Arc hasArc(int fromVertex, Edge e) {
        for (Arc a : this.outAdjacency.get(fromVertex)) {
            if (a.support == e) return a;
        }
        return null;
    }

    public void removeArc(Arc arc) {
        this.outAdjacency.get(arc.getSource()).remove(arc);
        this.inAdjacency.get(arc.getDest()).remove(arc);
    }

    public void removeEdge(Edge e) {
        if (this.isEdge(e)) {
            this.adjacency.get(e.dest).remove(e);
            this.adjacency.get(e.source).remove(e);
            removeArc(hasArc(e.source, e));
            removeArc(hasArc(e.dest,e));
            edgeCardinality--;
        }
    }

    public void removeVertex(int vertex) {
        for (Edge e : neighbours(vertex)) {
            removeEdge(e);
        }
        adjacency.set(vertex, null);
        inAdjacency.set(vertex, null);
        outAdjacency.set(vertex, null);

    }
}
