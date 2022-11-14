package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Utils.DelayedAction;
import org.firstinspires.ftc.teamcode.Utils.OneTap;

public class Claw {
    private static final double closedRight = 0.21;
    private static final double closedLeft = 0.89;
    private static final double openRight = 0.14;
    private static final double openLeft = 0.96;

    public static void open() {
        Hardware.rightClaw.setPosition(openRight);
        Hardware.leftClaw.setPosition(openLeft);
    }

    public static void close() {
        Hardware.rightClaw.setPosition(closedRight);
        Hardware.leftClaw.setPosition(closedLeft);
    }
}
