package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    private Servo arm;
    private LinearOpMode opMode;
    public Arm (LinearOpMode opMode) {
        this.opMode = opMode;
    }
    public void init() {
        arm = opMode.hardwareMap.get(Servo.class,"arm");
        setPosition(0);
    }
    public void setPosition (double pos) {
        arm.setPosition(pos);
    }
    public double getPosition () {
        return arm.getPosition();
    }
}
