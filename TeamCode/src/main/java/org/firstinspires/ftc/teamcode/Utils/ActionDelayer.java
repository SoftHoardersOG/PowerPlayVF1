package org.firstinspires.ftc.teamcode.Utils;

import java.util.Timer;
import java.util.TimerTask;

public class ActionDelayer {
    public static void delay(int msDelay, Lambda lambda){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                lambda.run();
            }
        }, msDelay);
    }
}
