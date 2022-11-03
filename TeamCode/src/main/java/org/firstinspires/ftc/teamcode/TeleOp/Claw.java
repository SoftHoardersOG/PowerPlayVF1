package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Utils.OneTap;

public class Claw {
    public static final double closedRight=0.21;
    public static final double closedLeft=0.89;
    static final double openRight=0.14;
    static final double openLeft=0.96;
    private static OneTap oneTapOpen = new OneTap();
    private static OneTap oneTapClosed = new OneTap();
    public static void run(Gamepad gamepad){
        if (oneTapOpen.onPress(gamepad.a)){
            Hardware.rightClaw.setPosition(openRight);
            Hardware.leftClaw.setPosition(openLeft);
        }
        if (oneTapClosed.onPress(gamepad.b)){
            Hardware.rightClaw.setPosition(closedRight);
            Hardware.leftClaw.setPosition(closedLeft);
        }
    }
}
