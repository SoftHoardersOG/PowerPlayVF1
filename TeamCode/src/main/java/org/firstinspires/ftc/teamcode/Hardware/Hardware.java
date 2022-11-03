package org.firstinspires.ftc.teamcode.Hardware;

import static org.firstinspires.ftc.teamcode.Hardware.HardwareUtils.*;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.TeleOp.Arm;


public class Hardware {
    public static DcMotor frontRight;
    public static DcMotor frontLeft;
    public static DcMotor backRight;
    public static DcMotor backLeft;
    public static Servo rightClaw;
    public static Servo leftClaw;
    public static DcMotorEx arm;
    public static Telemetry telemetry;

    public static void init(HardwareMap hardwareMap, Telemetry _telemetry) {
        HardwareUtils.hardwareMap = hardwareMap;
        telemetry=_telemetry;
        frontLeft = getDc("frontLeft");
        frontRight = getDc("frontRight");
        backLeft = getDc("backLeft");
        backRight = getDc("backRight");
        rightClaw = getServo("rightClaw");
        leftClaw = getServo("leftClaw");
        arm = getDcEx("arm");
        telemetry.addLine("Hardware mapping done!");
    }

    public static void configure(){
        rightClaw.setPosition(0.14);
        leftClaw.setPosition(0.96);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Arm.pid.setTarget(-50);
        telemetry.addLine("Hardware configurating done!");
    }
}
