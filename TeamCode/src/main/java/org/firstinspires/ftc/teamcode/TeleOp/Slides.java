package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;

public class Slides {
    private static final int rightSlidePositionUp = 2050;
    private static final int leftSlidePositionUp = -2050;
    private static final int rightSlidePositionMid = 1500;
    private static final int leftSlidePositionMid = -1500;

    public static void down() {
        Hardware.rightSlide.setPower(0.6);
        Hardware.leftSlide.setPower(0.6);
        Hardware.rightSlide.setTargetPosition(0);
        Hardware.leftSlide.setTargetPosition(0);
    }

    public static void mid() {
        Hardware.rightSlide.setTargetPosition(rightSlidePositionMid);
        Hardware.leftSlide.setTargetPosition(leftSlidePositionMid);
    }

    public static void up() {
        Hardware.rightSlide.setPower(1);
        Hardware.leftSlide.setPower(1);
        Hardware.rightSlide.setTargetPosition(rightSlidePositionUp);
        Hardware.leftSlide.setTargetPosition(leftSlidePositionUp);
    }
}
