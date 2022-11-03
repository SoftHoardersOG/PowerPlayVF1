package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.teamcode.TeleOp.Claw.closedLeft;
import static org.firstinspires.ftc.teamcode.TeleOp.Claw.closedRight;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Utils.ConditionAction;
import org.firstinspires.ftc.teamcode.Utils.CustomPid;

public class Arm {
    public static CustomPid pid = new CustomPid(0.01, 0.00002, 0.8);
    public static void run(Gamepad gamepad){
        pid.setPowerLimit(0.5);
        Hardware.arm.setPower(pid.control(Hardware.arm.getCurrentPosition()));
        if (gamepad.y){
            Hardware.rightClaw.setPosition(closedRight);
            Hardware.leftClaw.setPosition(closedLeft);
            pid.setPIDCoef(0.01, 0.00002, 0.9);
            pid.setTarget(-390);
        }
        if (gamepad.x){
            Hardware.rightClaw.setPosition(closedRight);
            Hardware.leftClaw.setPosition(closedLeft);
            pid.setPIDCoef(0.01, 0.00002, 0.9);
            pid.setTarget(-50);
        }
        if (gamepad.dpad_left){
            Hardware.rightClaw.setPosition(closedRight);
            Hardware.leftClaw.setPosition(closedLeft);
            pid.setTarget(-140);
        }
    }
}
