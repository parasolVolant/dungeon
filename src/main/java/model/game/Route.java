package model.game;

import model.labyrinth.GraphClasses.CoverTree;
import model.player.Player;
import model.labyrinth.Graph.*;

import java.util.List;

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
        CoverTree tree = new CoverTree(WIDTH, HEIGHT);

        initRoute();
    }

    private void initRoute() {
        setCurrentRoom(0,0);
        currentRoom.emptyRoom();
    }

    public void setCurrentRoom(int row,int column){
        currentRoom = new Room(row,column);
        visitedRooms[row][column] = true;
    }






}
