/*package org.firstinspires.ftc.teamcode.skystone;

import org.firstinspires.ftc.teamcode.common.RobotConfig;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="Tele Op", group="Linear Opmode")

public class DriverControlled extends LinearOpMode {

    
    // Declare OpMode members.
    private Servo bringPlatform = null;
    
    // Declaring Variables
    private double leftPower;
    private double rightPower;
    private double armPower;
    private double turnPower;
    private double upPower;
    private double bumpPower;
    private double platPower;
    
    RobotConfig robotConfig = new RobotConfig(this);
    
    @Override
    public void runOpMode() throws InterruptedException {
        
        bringPlatform = robotConfig.bringPlatform;
        
        robotConfig.init();
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        telemetry.addData("Status: ", "Hardware Configured");
        telemetry.update();

        robotConfig.leftDrive.setDirection(DcMotor.Direction.REVERSE);
        // bringPlatform.setDirection(Servo.Direction.REVERSE);
        // rightDrive.setDirectiron(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {

           

            leftPower = gamepad1.left_stick_y;
            rightPower  =  gamepad1.right_stick_y;
            armPower = gamepad2.left_stick_y;
            turnPower = -gamepad2.right_stick_x;
            bumpPower = 0;


           
            robotConfig.leftDrive.setPower(leftPower/2);
            robotConfig.rightDrive.setPower(rightPower/2);
            robotConfig.arm_motor.setPower(armPower/3);
            robotConfig.grabber_turn_two.setPosition(turnPower/2);


            if (gamepad2.right_bumper) {
                robotConfig.grabber_vert.setPosition(bumpPower+.5);
            } else if (gamepad2.left_bumper){
                robotConfig.grabber_vert.setPosition(bumpPower-.5);
            } else if (gamepad1.left_bumper){
                robotConfig.bringPlatform.setPosition(.9);
            } else if (gamepad1.right_bumper){
                robotConfig.bringPlatform.setPosition(0); 
            }
            if (gamepad2.x){
                robotConfig.grabber_turn.setPosition(turnPower+.4);
            }
            if (gamepad2.b){
                robotConfig.grabber_turn.setPosition(turnPower-.4);
            } 
          

        }
    }
}
*/