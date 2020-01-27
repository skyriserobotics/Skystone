
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareDevice;
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
@TeleOp(name="ShreyasArmCode", group="Linear Opmode")

public class ShreyasArmCode extends LinearOpMode {    
    // Declaring Variables
    private double Outback;
    private double wristPower;
    private double liftPower;
    private double grabPower;
    private Servo grabber_turn_two = null;
    private Servo grabber_turn = null;
    private Servo grabber_vert = null;
    private DcMotor lift_arm = null;
    
    
    @Override
    public void runOpMode() throws InterruptedException {
        grabber_turn_two = hardwareMap.get(Servo.class, "grabber_turn_two");
        grabber_turn = hardwareMap.get(Servo.class, "grabber_turn"); 
        grabber_vert = hardwareMap.get(Servo.class, "grabber_vert");
        lift_arm = hardwareMap.get(DcMotor.class, "lift_arm");
        
        telemetry.addData("Status: ", "Hardware Configured");
        telemetry.update();

        lift_arm.setDirection(DcMotor.Direction.REVERSE);
        
        waitForStart();
        while (opModeIsActive()) {
              // Only 3 Main Gamepad Inputs
              Outback = gamepad2.right_stick_y;
              wristPower  =  gamepad2.right_stick_x;
              liftPower = gamepad2.left_stick_y;
              //grabPower = gamepad2.left_bumper;
                 //lifting the ARM  
                telemetry.addData("l", Double.toString(liftPower));
                telemetry.update();
                lift_arm.setPower(-liftPower*0.3);
                
                  if (Outback > 0) {
                telemetry.addData("l", "p");
                telemetry.update();
                //grabber_turn_two.setPosition(0.5);
               grabber_turn.setPosition(0);
                 }
                 
                    else if (Outback < 0); {
                telemetry.addData("l", "p");
                telemetry.update();
                //grabber_turn_two.setPosition(0.5);
               grabber_turn.setPosition(1);
                 }
                
    
                //turn the wrist
                 if (wristPower > 0) {
                telemetry.addData("l", "p");
                telemetry.update();
                //grabber_turn_two.setPosition(0.5);
               grabber_turn_two.setPosition(grabber_turn_two.getPosition()-0.3);
                 }
                // reverse motion of the wrist
                  else if (wristPower < 0) {
                telemetry.addData("l", "p");
                telemetry.update();
                //grabber_turn_two.setPosition(1);
                grabber_turn_two.setPosition(grabber_turn_two.getPosition()+0.3); 
                }
                /*if (grabPower > 0) {
                telemetry.addData("l", "p");
                telemetry.update();
                grabber_vert.setPosition(0);
                }*/
                
                if (gamepad2.left_bumper) {    
                telemetry.addData("left", "p");
                telemetry.update();
                grabber_vert.setPosition(0);
                }
                else if (gamepad2.right_bumper) {
                telemetry.addData("right", "p");
                telemetry.update();
                grabber_vert.setPosition(1);
                }
             
             
               
        
    }
    
 }
}

 

