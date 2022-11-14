package org.firstinspires.ftc.teamcode.Utils;

import static org.firstinspires.ftc.teamcode.Hardware.Hardware.telemetry;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;

public class TelemetryManager {
    public static void manage(){
        telemetry.addData("right slide position: ", Hardware.rightSlide.getCurrentPosition());
        telemetry.addData("left slide position: ", Hardware.leftSlide.getCurrentPosition());
        telemetry.addData("arm position: ", Hardware.arm.getCurrentPosition());
        telemetry.update();
    }
}
