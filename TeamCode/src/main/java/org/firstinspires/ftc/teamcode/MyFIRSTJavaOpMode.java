package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class MyFIRSTJavaOpMode extends LinearOpMode {
    private Servo servoTest;
    private DcMotor motorTest;
    private float motorPower;
    @Override
    public void runOpMode() {
        servoTest = hardwareMap.get(Servo.class, "servoTest");
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        while (opModeIsActive()) {
            motorPower = - gamepad1.left_stick_y;
            motorTest.setPower(motorPower);
        }
    }
}
