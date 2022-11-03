package org.firstinspires.ftc.teamcode.Utils;

public class OneTap {
    private boolean firstPress = true;
    private int count = 0;

    public void incrementCount() {
        count++;
    }

    public boolean onPressN(boolean button, int numberOfActions) {
        boolean result;
        if (button && firstPress && count <= numberOfActions) {
            result = true;
            if (count == numberOfActions)
                firstPress = false;
        } else {
            result = false;
            count = 0;
        }
        if (!button) {
            firstPress = true;
        }
        return result;
    }


    public boolean onPress(boolean button) {
        boolean result;
        if (button && firstPress) {
            result = true;
            firstPress = false;
        } else {
            result = false;
        }
        if (!button) {
            firstPress = true;
        }
        return result;
    }
}