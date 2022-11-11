package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.teamcode.TeleOp.Claw.closedLeft;
import static org.firstinspires.ftc.teamcode.TeleOp.Claw.closedRight;
import static org.firstinspires.ftc.teamcode.TeleOp.Claw.openLeft;
import static org.firstinspires.ftc.teamcode.TeleOp.Claw.openRight;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Utils.ConditionAction;
import org.firstinspires.ftc.teamcode.Utils.CustomPid;
import org.firstinspires.ftc.teamcode.Utils.DelayedAction;

public class Arm {
    public static CustomPid pid = new CustomPid(0.01, 0.00002, 0.8);
    private static DelayedAction delayedAction = new DelayedAction(1200);

    private static DelayedAction delayedAction2 = new DelayedAction(100);
    private static DelayedAction delayedAction3 = new DelayedAction(100);
    public static void run(Gamepad gamepad){
        if (delayedAction.runAction()){
            Hardware.rightClaw.setPosition(openRight);
            Hardware.leftClaw.setPosition(openLeft);
        }
        if (delayedAction2.runAction()){
            Hardware.rightSlide.setTargetPosition(0);
            Hardware.leftSlide.setTargetPosition(0);
        }
        if (delayedAction3.runAction()){
            Hardware.rightSlide.setTargetPosition(2270);
            Hardware.leftSlide.setTargetPosition(-2270);
            pid.setPIDCoef(0.01, 0.00002, 0.9);
            pid.setTarget(-405);
        }
        pid.setPowerLimit(0.5);
        Hardware.arm.setPower(pid.control(Hardware.arm.getCurrentPosition()));
        if (gamepad.dpad_up){
            Hardware.rightClaw.setPosition(closedRight);
            Hardware.leftClaw.setPosition(closedLeft);
            delayedAction3.callAction();
        }
        if (gamepad.x){
            Hardware.rightClaw.setPosition(closedRight);
            Hardware.leftClaw.setPosition(closedLeft);
            pid.setPIDCoef(0.01, 0.00002, 0.9);
            pid.setTarget(-15);
        }
        if (gamepad.dpad_left){
            Hardware.rightClaw.setPosition(closedRight);
            Hardware.leftClaw.setPosition(closedLeft);
            delayedAction2.callAction();
            pid.setTarget(-15);
            delayedAction.callAction();
        }
    }
}
