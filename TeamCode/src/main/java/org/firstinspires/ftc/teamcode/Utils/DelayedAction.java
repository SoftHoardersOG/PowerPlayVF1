package org.firstinspires.ftc.teamcode.Utils;

public class DelayedAction {
    private long delay;
    private boolean actionCalled;
    public long actionCalledTime;

    public DelayedAction(int ms) {
        delay = ms;
        actionCalled = false;
    }

    public void modifyDelay(int ms) {
        delay = ms;
    }

    public void callAction() {
        if (!actionCalled) {
            actionCalled = true;
            actionCalledTime = System.currentTimeMillis();
        }
    }

    public boolean runAction() {
        if (actionCalled && System.currentTimeMillis() - actionCalledTime > delay) {
            actionCalled = false;
            return true;
        }
        return false;
    }
}