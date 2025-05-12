package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

public class TeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        Drivetrain Drive = new Drivetrain();
        Drive.runOpMode();
    }
}
