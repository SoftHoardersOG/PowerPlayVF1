package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RoadRunner.drive.SampleMecanumDrive;

@TeleOp
public class MainTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive=new SampleMecanumDrive(hardwareMap);
        Initializations.init(hardwareMap, drive);
        waitForStart();
        while(opModeIsActive()&&!isStopRequested()){
            Movement.run(gamepad1);
        }
    }
}
