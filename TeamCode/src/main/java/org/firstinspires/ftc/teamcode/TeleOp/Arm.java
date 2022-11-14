package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Utils.ConditionAction;
import org.firstinspires.ftc.teamcode.Utils.CustomPid;
import org.firstinspires.ftc.teamcode.Utils.DelayedAction;

public class Arm {
    private static final CustomPid pid = new CustomPid(0.01, 0.00002, 0.9);
    private static final int downPosition = -15;
    private static final int upPosition = -405;

    public static void updatePid() {
        Hardware.arm.setPower(pid.control(Hardware.arm.getCurrentPosition()));
    }

    public static void down() {
        pid.setTarget(downPosition);
    }

    public static void up() {
        pid.setTarget(upPosition);
    }

    public static void setPidPowerLimit(double limit) {
        pid.setPowerLimit(limit);
    }
}
