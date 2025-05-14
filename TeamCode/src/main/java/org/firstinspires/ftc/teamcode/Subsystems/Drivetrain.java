package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.GoBildaPinpointDriver;

public class Drivetrain  {
    GoBildaPinpointDriver odometry;
    private LinearOpMode opMode;
    private DcMotor frontleft;
    private DcMotor frontright;
    private DcMotor backleft;
    private DcMotor backright;

    public Drivetrain(LinearOpMode opMode) {
        this.opMode = opMode;
    }
    public void init() {
        odometry = opMode.hardwareMap.get(GoBildaPinpointDriver.class,"odometry");
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

        opMode.telemetry.addData("X pos: ",odometry.getPosX(DistanceUnit.MM));
        opMode.telemetry.addData("Y pos: ",odometry.getPosY(DistanceUnit.MM));
        opMode.telemetry.addData("Heading: ",odometry.getHeading(AngleUnit.DEGREES));
        odometry.update();
    }
}
