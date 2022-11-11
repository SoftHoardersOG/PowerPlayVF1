package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Utils.DelayedAction;
import org.firstinspires.ftc.teamcode.Utils.OneTap;

public class Claw {
    public static final double closedRight=0.21;
    public static final double closedLeft=0.89;
    static final double openRight=0.14;
    static final double openLeft=0.96;
    private static OneTap oneTapOpen = new OneTap();
    private static OneTap oneTapClosed = new OneTap();
    public static DelayedAction delayedAction = new DelayedAction(200);
    public static DelayedAction delayedAction2 = new DelayedAction(100);
    public static DelayedAction delayedAction4 = new DelayedAction(100);
    public static DelayedAction delayedAction3 = new DelayedAction(900);
    public static void run(Gamepad gamepad){
        if(delayedAction.runAction()){
            Arm.pid.setTarget(-80);
        }
        if (delayedAction3.runAction()){
            Hardware.rightClaw.setPosition(openRight);
            Hardware.leftClaw.setPosition(openLeft);
        }
        if (delayedAction4.runAction()){
            Hardware.rightSlide.setTargetPosition(0);
            Hardware.leftSlide.setTargetPosition(0);
        }
        if (delayedAction2.runAction()){
            Hardware.rightClaw.setPosition(closedRight);
            Hardware.leftClaw.setPosition(closedLeft);
            delayedAction4.callAction();
            Arm.pid.setTarget(-30);
            delayedAction3.callAction();
        }
        if (oneTapOpen.onPress(gamepad.dpad_down)){
            Hardware.rightClaw.setPosition(openRight);
            Hardware.leftClaw.setPosition(openLeft);
            delayedAction2.callAction();
        }
        if (oneTapClosed.onPress(gamepad.b)){
            Hardware.rightClaw.setPosition(closedRight);
            Hardware.leftClaw.setPosition(closedLeft);
            delayedAction.callAction();
        }
    }
}
