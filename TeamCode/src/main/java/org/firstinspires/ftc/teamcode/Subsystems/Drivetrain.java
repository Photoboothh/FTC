package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Drivetrain  {
    private LinearOpMode opMode;
    private DcMotor frontleft;
    private DcMotor frontright;
    private DcMotor backleft;
    private DcMotor backright;

    public Drivetrain(LinearOpMode opMode) {
        this.opMode = opMode;
    }
    public void init() {
        frontleft = opMode.hardwareMap.get(DcMotor.class, "frontleft");
        frontright = opMode.hardwareMap.get(DcMotor.class, "frontright");
        backleft = opMode.hardwareMap.get(DcMotor.class, "backleft");
        backright = opMode.hardwareMap.get(DcMotor.class, "backright");

        frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
        backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void Drive(double straight, double strafe, double turn) {
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
