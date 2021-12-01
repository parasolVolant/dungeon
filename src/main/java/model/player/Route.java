package model.player;

import model.game.Game;
import model.labyrinth.graph_classes.CoverTree;
import model.room.*;

public class Route {

    private int width;
    private int height;
    private static final Room EMPTY_ROOM = new EmptyRoom();
    private static final Room LAST_ROOM = new LastRoom();

    CoverTree coverTree;
    boolean[][] visitedRooms;
    Player player;
    Room currentRoom;
    RoomGenerator generator;

    public Route(Game game) {
        this.player = game.getPlayer();
        this.width= game.getWidth();
        this.height= game.getHeight();
        visitedRooms = new boolean[width][height];
        coverTree = new CoverTree(width, height);
        currentRoom = new EmptyRoom();
        visitedRooms[0][0] = true;
        generator = new RoomGenerator();
    }

    public boolean isPath(int row, int col) {
        return coverTree.isPath(player.getPosX(), player.getPosY(), row, col);
    }

    private boolean isVisited(int row, int col) {
        return visitedRooms[row][col];
    }

    private boolean isLast() {
        return player.getPosX() == width-1 && player.getPosY() == height-1;
    }

    private void event() {
        currentRoom.event(player);
    }

    private void setCurrentRoom(int row,int column){
        if(isLast()) {
            currentRoom = LAST_ROOM;
            return;
        }
        if (isVisited(row, column)) {
            currentRoom = EMPTY_ROOM;
            return;
        }
        //currentRoom = generator.createRoom();
        currentRoom = new MonsterRoom();
        visitedRooms[row][column] = true;
    }

    public void update(int row, int col) {
        setCurrentRoom(row, col);
        event();
    }
}
