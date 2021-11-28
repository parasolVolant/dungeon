package model.player;

import model.room.Room;
import model.labyrinth.Graph.Edge;
import model.labyrinth.GraphClasses.CoverTree;
import model.player.Player;

import java.util.List;

public class Route {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    CoverTree coverTree;
    boolean[][] visitedRooms;
    Player player;
    Room currentRoom;

    public Route(Player player) {
        this.player = player;
        visitedRooms = new boolean[WIDTH][HEIGHT];
        coverTree = new CoverTree(WIDTH, HEIGHT);
        initRoute();
    }

    private void initRoute() {
        setCurrentRoom(0,0);
        //currentRoom.emptyRoom();
    }

    public List<Edge> getGraph() {
        return coverTree.getGraph();
    }

    public boolean isPath(int row, int col) {
        return coverTree.isPath(player.getPosX(), player.getPosY(), row, col);
    }

    public boolean isPath(Edge edge) { return coverTree.isPath(edge);}

    public boolean isVisited(int row, int col) {
        return visitedRooms[row][col];
    }

    public void setCurrentRoom(int row,int column){
        //currentRoom = new Room(row,column);
        visitedRooms[row][column] = true;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
