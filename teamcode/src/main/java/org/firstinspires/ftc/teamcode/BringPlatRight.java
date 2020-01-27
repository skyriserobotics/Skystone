

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@Autonomous(name="BringPlatRight", group="Linear Opmode")

public class BringPlatRight extends LinearOpMode {

    // Declare OpMode members.

    private DcMotor frontleftDrive = null;
    private Servo bringPlatform = null;
    private DcMotor frontrightDrive = null;
    private DcMotor backleftDrive = null;
    private DcMotor backrightDrive = null;
    private DcMotor arm_motor = null;
    private Servo grabber_vert = null;
    private Servo grabber_turn = null;
    private Servo grabber_turn_two = null;

    @Override
    public void runOpMode() {
        
        frontleftDrive = hardwareMap.get(DcMotor.class, "frontleftDrive");
        backrightDrive = hardwareMap.get(DcMotor.class, "backrightDrive");
        backleftDrive = hardwareMap.get(DcMotor.class, "backleftDrive");
        frontrightDrive = hardwareMap.get(DcMotor.class, "frontrightDrive");
        arm_motor = hardwareMap.get(DcMotor.class, "lift_arm");
        bringPlatform = hardwareMap.get(Servo.class, "bringPlatform");
        grabber_turn_two = hardwareMap.get(Servo.class, "grabber_turn_two");
        grabber_turn = hardwareMap.get(Servo.class, "grabber_turn");
        grabber_vert = hardwareMap.get(Servo.class, "grabber_vert");

        telemetry.addData("Status: ", "Hardware Configured");
        telemetry.update();
        
        frontleftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontrightDrive.setDirection(DcMotor.Direction.FORWARD);
        backleftDrive.setDirection(DcMotor.Direction.REVERSE);
        backrightDrive.setDirection(DcMotor.Direction.FORWARD);
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            /*
            // Going Forward
            frontleftDrive.setPower(-0.3);
            frontrightDrive.setPower(-0.3);
            backleftDrive.setPower(-0.3);
            backrightDrive.setPower(-0.3);
          
            sleep(1500);
              
            // Bringing down Grabber
            bringPlatform.setPosition(0);
            
            
            frontleftDrive.setPower(0);
            frontrightDrive.setPower(0);
            backleftDrive.setPower(0);
            backrightDrive.setPower(0);
            sleep(1000);
              
            // Going back
            frontleftDrive.setPower(0.5);
            frontrightDrive.setPower(0.3);
            backleftDrive.setPower(0.5);
            backrightDrive.setPower(0.3);
              
            sleep(1500);
            
            bringPlatform.setPosition(1);
            
            frontleftDrive.setPower(0);
            frontrightDrive.setPower(0);
            backleftDrive.setPower(0);
            backrightDrive.setPower(0);
            sleep(1000);
            
            */
            
            // Going under the bridge (Left)
            frontleftDrive.setPower(0.5);
            frontrightDrive.setPower(-0.5);
            backrightDrive.setPower(0.5);
            backleftDrive.setPower(-0.5);
          
            sleep(100000);

        }
    }
}
