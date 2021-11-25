package model.game;

import model.labyrinth.GraphClasses.CoverTree;
import model.player.Player;

public class Route {

    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    CoverTree coverTree;
    boolean[][] visitedRooms;
    Player player;
    Room currentRoom;

    public Route(Player player) throws InterruptedException{
        this.player = player;
        visitedRooms = new boolean[WIDTH][HEIGHT];
        coverTree = new CoverTree(WIDTH, HEIGHT);
        initRoute();
    }

    private void initRoute() {
        setCurrentRoom(0,0);
        currentRoom.emptyRoom();
    }

    public boolean isPath(int row, int col) {
        return coverTree.isPath(player.getPosX(), player.getPosY(), row, col);
    }

    public void setCurrentRoom(int row,int column){
        currentRoom = new Room(row,column);
        visitedRooms[row][column] = true;
    }

}
