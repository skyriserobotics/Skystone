package org.firstinspires.ftc.teamcode.skystone;

import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "Tele Op", group = "Linear Opmode")

public class Driving extends LinearOpMode {
    // Declaring Variables for Motors and Servos
    // Declaring Variables for Powers of Motors and Servos
    private double forback;
    private double rightleft;
    private double turnPower;
    private Servo bringPlatform = null;
    private DcMotor frontleftDrive = null;
    private DcMotor frontrightDrive = null;
    private DcMotor backleftDrive = null;
    private DcMotor backrightDrive = null;
    private DcMotor arm_motor = null;
    private Servo grabber_vert = null;
    private Servo grabber_turn = null;
    private Servo grabber_turn_two = null;
      private Servo capstone_servo = null;
    private double armPower;
    private double turnPowerm;
    private double bumpPower = 0;

    // When "INIT" is pressed
    @Override
    public void runOpMode() throws InterruptedException {
        // Doing all the hardware mappings
        frontleftDrive = hardwareMap.get(DcMotor.class, "frontleftDrive");
        backrightDrive = hardwareMap.get(DcMotor.class, "backrightDrive");
        backleftDrive = hardwareMap.get(DcMotor.class, "backleftDrive");
        frontrightDrive = hardwareMap.get(DcMotor.class, "frontrightDrive");
        arm_motor = hardwareMap.get(DcMotor.class, "lift_arm");
        bringPlatform = hardwareMap.get(Servo.class, "bringPlatform");
        grabber_turn_two = hardwareMap.get(Servo.class, "grabber_turn_two");
        grabber_turn = hardwareMap.get(Servo.class, "grabber_turn");
        grabber_vert = hardwareMap.get(Servo.class, "grabber_vert");
          capstone_servo = hardwareMap.get(Servo.class, "capstone_servo");
        // Telling Driver that Hardware is Configured
        telemetry.addData("Status: ", "Hardware Configured");
        telemetry.update();
        
        // Reversing Motor Direction to make the robot move correctly
        frontleftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontrightDrive.setDirection(DcMotor.Direction.REVERSE);
        // Waiting for "START" to be pressed
        waitForStart();

        while (opModeIsActive()) {
            // Setting Values of Power Variables
            forback = gamepad1.left_stick_x;
            rightleft = -gamepad1.left_stick_y;
            armPower = gamepad2.left_stick_y;
            turnPowerm = gamepad1.right_stick_x;
            turnPower = -gamepad2.right_stick_x;
            bumpPower = 0;


            // For Going Forward and Backward
            frontleftDrive.setPower(-(forback));
            frontrightDrive.setPower(forback);
            backleftDrive.setPower(forback);
            backrightDrive.setPower(forback);

            // Strafing Right
            if (rightleft > 0) {
                telemetry.addData("Strafing", "Right");
                telemetry.update();
                frontleftDrive.setPower(-(rightleft));
                frontrightDrive.setPower(-(rightleft));
                backleftDrive.setPower(-(rightleft));
                backrightDrive.setPower(rightleft);
            }
            // Strafing Left
            if (rightleft < 0) {
                telemetry.addData("Strafing", "Left");
                telemetry.update();
                frontleftDrive.setPower(-(rightleft));
                frontrightDrive.setPower(-(rightleft));
                backrightDrive.setPower(rightleft);
                backleftDrive.setPower(-(rightleft));
            }

            // Twisting Right
            if (turnPowerm > 0) {
                telemetry.addData("Turning", "Right");
                telemetry.update();
                frontleftDrive.setPower(-turnPowerm);
                frontrightDrive.setPower(turnPowerm);
                backleftDrive.setPower(-turnPowerm);
                backrightDrive.setPower(-turnPowerm);
            }

            // Twisting Left
            if (turnPowerm < 0) {
                telemetry.addData("Turning", "Left");
                telemetry.update();
                frontleftDrive.setPower(-turnPowerm);
                frontrightDrive.setPower(turnPowerm);
                backleftDrive.setPower(-turnPowerm);
                backrightDrive.setPower(-turnPowerm);
            }
            // Engaging and Disengaging the Platform
            if (gamepad1.left_bumper) {
                telemetry.addData("Platform", "Engaged");
                telemetry.update();
                bringPlatform.setPosition(.7);
            } else if (gamepad1.right_bumper) {
                telemetry.addData("Platform", "Disengaged");
                telemetry.update();
                bringPlatform.setPosition(.3);
            }
            
            // Setting Arm Motor to its corresponding Power
            arm_motor.setPower(armPower / 3);
            // Setting Grabber Turn 2 to its corresponding Power
            grabber_turn_two.setPosition(turnPower / 2);
            
            // Engaging and Disengaging Stone
            if (gamepad2.right_bumper) {
                grabber_vert.setPosition(bumpPower + .5);
            } else if (gamepad2.left_bumper) {
                grabber_vert.setPosition(bumpPower - .5);
            }
            // Moving Main Arm Turning Servo
            if (gamepad2.x) {
                grabber_turn.setPosition(turnPower + .4);
                telemetry.addData("d", "l");
                telemetry.update();
            }
            if (gamepad2.b) {
                grabber_turn.setPosition(turnPower - .4);
                telemetry.addData("d", "r");
                telemetry.update();
            }
              if (gamepad2.y) {
                capstone_servo.setPosition(0);
                telemetry.addData("Servo", "DOwn/or up");
                telemetry.update();
            }
              if (gamepad2.a) {
                capstone_servo.setPosition(0.4);
                telemetry.addData("Servo", "Down/or up");
                telemetry.update();
            }

        }
    }
}
