package org.firstinspires.ftc.teamcode.TeleOp;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.RoadRunner.drive.SampleMecanumDrive;

public class Movement {
    private static SampleMecanumDrive drive;
    private static int limitSpeed;

    public static void init(SampleMecanumDrive _drive) {
        drive = _drive;
    }

    public static void run(Gamepad gamepad1) {
        setLimitSpeed(gamepad1);
        drive.setWeightedDrivePower(
                new Pose2d(
                        -gamepad1.right_stick_y / limitSpeed,
                        -gamepad1.right_stick_x / limitSpeed,
                        -gamepad1.left_stick_x / limitSpeed
                )
        );
        drive.update();
    }

    private static void setLimitSpeed(Gamepad gamepad) {
        limitSpeed = 4;
    }
}
