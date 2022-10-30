package org.firstinspires.ftc.teamcode.TeleOp;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.RoadRunner.drive.SampleMecanumDrive;

public class Movement {
    private static SampleMecanumDrive drive;
    public static void init(SampleMecanumDrive _drive){
        drive=_drive;
    }
    public static void run (Gamepad gamepad1){
        drive.setWeightedDrivePower(
                new Pose2d(
                        -gamepad1.right_stick_y,
                        -gamepad1.right_stick_x,
                        -gamepad1.left_stick_x
                )
        );
        drive.update();
    }
}
