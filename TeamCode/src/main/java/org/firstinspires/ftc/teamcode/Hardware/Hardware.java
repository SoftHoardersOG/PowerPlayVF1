package org.firstinspires.ftc.teamcode.Hardware;

import static org.firstinspires.ftc.teamcode.Hardware.HardwareUtils.*;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardware {
    public static DcMotor frontRight;
    public static DcMotor frontLeft;
    public static DcMotor backRight;
    public static DcMotor backLeft;

    public static void init(HardwareMap hardwareMap) {
        HardwareUtils.hardwareMap = hardwareMap;
        frontLeft = getDc("frontLeft");
        frontRight = getDc("frontRight");
        backLeft = getDc("backLeft");
        backRight = getDc("backRight");
    }
}
