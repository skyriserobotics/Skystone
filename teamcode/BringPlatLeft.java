/*
Copyright 2019 FIRST Tech Challenge Team 16525

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@Autonomous(name="BringPlatLeft", group="Linear Opmode")

public class BringPlatLeft extends LinearOpMode {

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
            frontrightDrive.setPower(-0.7);
            backrightDrive.setPower(0.5);
            backleftDrive.setPower(-0.5);
          
            sleep(100000);

        }
    }
}
