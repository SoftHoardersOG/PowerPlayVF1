package org.firstinspires.ftc.teamcode.Utils;

public class ConditionAction {
    private boolean actionCalled = false;

    public void callAction() {
        actionCalled = true;
    }

    public boolean runAction(boolean condition) {
        if (actionCalled && condition) {
            actionCalled = false;
            return true;
        }
        return false;
    }
}
