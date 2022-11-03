package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.RoadRunner.drive.SampleMecanumDrive;

public class Initializations {
    public static void init(HardwareMap hardwareMap, SampleMecanumDrive drive, Telemetry telemetry){
        Hardware.init(hardwareMap, telemetry);
        Movement.init(drive);
        Hardware.configure();
    }
}
