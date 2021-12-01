package model.status;

import model.Move;

public class ClosedStatus implements StatusState{
    @Override
    public void show(Status status) {
        status.getView().handleMove(new Move("You closed the status window."));
    }
}
