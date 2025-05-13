package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Drivetrain extends LinearOpMode {
    private DcMotor frontleft;
    private DcMotor frontright;
    private DcMotor backleft;
    private DcMotor backright;
    @Override
    public void runOpMode() {
        frontleft = hardwareMap.get(DcMotor.class, "frontleft");
        frontright = hardwareMap.get(DcMotor.class, "frontright");
        backleft = hardwareMap.get(DcMotor.class, "backleft");
        backright = hardwareMap.get(DcMotor.class, "backright");

        frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
        backleft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();;

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double straight = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(straight) + Math.abs(strafe) + Math.abs(turn), 1);
            double frontleftPower = (straight + strafe + turn)/denominator;
            double backleftPower = (straight - strafe + turn)/denominator;
            double frontrightPower = (straight - strafe - turn)/denominator;
            double backrightPower = (straight + strafe - turn)/denominator;

            frontleft.setPower(frontleftPower);
            backleft.setPower(backleftPower);
            frontright.setPower(frontrightPower);
            backright.setPower(backrightPower);

        }
    }
}
