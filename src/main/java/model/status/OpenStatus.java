package model.status;

import model.Move;

public class OpenStatus implements StatusState{

    @Override
    public void show(Status status) {
        System.out.println(status.toString());
        status.getView().handleMove(new Move(status.toString()));
    }

}
