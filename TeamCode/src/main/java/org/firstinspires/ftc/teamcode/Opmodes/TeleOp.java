package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

public class TeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        Drivetrain drive = new Drivetrain(this);
        Arm arm = new Arm(this);
        drive.init();
        arm.init();

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            drive.Drive(-gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x);
            if (gamepad1.a) {arm.setPosition(0.5);}
            if (gamepad1.b) {arm.setPosition(0.25);}
        }
    }
}
