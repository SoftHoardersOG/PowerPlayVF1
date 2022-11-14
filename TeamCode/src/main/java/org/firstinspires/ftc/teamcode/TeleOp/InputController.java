package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;


import org.firstinspires.ftc.teamcode.Utils.ActionDelayer;

public class InputController {
    private static Gamepad gamepad1;
    private static Gamepad gamepad2;

    public static void control(Gamepad _gamepad1, Gamepad _gamepad2) {
        gamepad1 = _gamepad1;
        gamepad2 = _gamepad2;
        Arm.updatePid();
        Movement.run(gamepad1);
        placeCone();
        highJunction();
    }

    private static void placeCone() {
        if (gamepad1.dpad_down) {
            ActionDelayer.delay(0, Claw::open);
            ActionDelayer.delay(100, Claw::close);
            ActionDelayer.delay(200, Arm::down);
            ActionDelayer.delay(300, Slides::down);
            ActionDelayer.delay(1000, Claw::open);
        }
    }

    private static void highJunction() {
        if (gamepad1.dpad_up) {
            ActionDelayer.delay(0, Claw::close);
            ActionDelayer.delay(100, Arm::up);
            ActionDelayer.delay(100, Slides::up);
        }
    }
}
