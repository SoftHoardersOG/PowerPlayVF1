package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;

public class Slides {
    private static final int rightSlidePositionUp=2000;
    private static final int leftSlidePositionUp=-2000;
    private static final int rightSlidePositionMid=0;
    private static final int leftSlidePositionMid=0;
    public static void run(Gamepad gamepad){
        if (gamepad.dpad_up){
            Hardware.rightSlide.setTargetPosition(rightSlidePositionUp);
            Hardware.leftSlide.setTargetPosition(leftSlidePositionUp);
        }
        if (gamepad.dpad_right){
            Hardware.rightSlide.setTargetPosition(rightSlidePositionMid);
            Hardware.leftSlide.setTargetPosition(leftSlidePositionMid);
        }
        if (gamepad.dpad_down){
            Hardware.rightSlide.setTargetPosition(0);
            Hardware.leftSlide.setTargetPosition(0);
        }
    }
}
