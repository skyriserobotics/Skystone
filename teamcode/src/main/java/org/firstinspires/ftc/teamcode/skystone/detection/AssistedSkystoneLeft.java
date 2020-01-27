
package org.firstinspires.ftc.teamcode.skystone.detection;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

@Autonomous(name = "Assisted Skystone Left", group = "Concept")

public class AssistedSkystoneLeft extends LinearOpMode {
    // Declaring Labels and ObjDetect Models
    private static final String TFOD_MODEL_ASSET = "Skystone.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Stone";
    private static final String LABEL_SECOND_ELEMENT = "Skystone";
    double ObjectAngle;
    double TargetHeightRatio;
    int ImageHeight;
    float ObjectHeight;
    int objects;
    double leftPower;   
    double rightPower;
    double ObjectHeightRatio;
    private DcMotor frontleftDrive = null;
    private DcMotor frontrightDrive = null;
    private DcMotor backleftDrive = null;
    private DcMotor backrightDrive = null;
    private DcMotor lift_arm = null;
    private Servo grabber_turn = null;
    private Servo grabber_vert = null;
    int count = 0;
    int assess =0;
    int pre=0;
    //Vuforia Key Fragment
    private static final String VUFORIA_KEY =
            "AZAarN7/////AAABmbwaPFXcCUKSuQXshhARVD0edTn5yksB2f5i9qUU/5VB4UkFTmki8BWBIyVGemPQFrTp5KfsGLrHy1FTZePcR9qfC3PD0IyiGJGy1Vbxp1dA4PUCvinmAPUEPZLopfxRYzyFc7uIhljkjcdiOLLzqreumEb2c4/7s1n4AgkxAxs8H6k/Mg+FCNOWqbSekb7msXG8IjgcqGrH7J16MYjvNZw8KHMShM2QDNyzfyyKVrSA4Hw1Ys6zc9yGuuC/go5IOWhFdqvwLMfEA331wfcLCPxXAXSTeOpfN+Jy7vRk8DMeoq5aooF5k3U5xXjyTxwJdzttGnmfNifw7kI8/GWvZS9U8FGjoki2QruawoJDJ3CZ";
    // Initialzing both vuforia and tfod
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;

    @Override
    public void runOpMode() {
        // Initializing Vuforia
        initVuforia();
        // Finding the Perfect Target Height Ratio
        TargetHeightRatio = 2;
        // Doing the Hardware Mappings
        frontleftDrive = hardwareMap.get(DcMotor.class, "frontleftDrive");
        backrightDrive = hardwareMap.get(DcMotor.class, "backrightDrive");
        backleftDrive = hardwareMap.get(DcMotor.class, "backleftDrive");
        frontrightDrive = hardwareMap.get(DcMotor.class, "frontrightDrive");
        grabber_vert = hardwareMap.get(Servo.class, "grabber_vert");
        grabber_turn = hardwareMap.get(Servo.class, "grabber_turn");
        lift_arm = hardwareMap.get(DcMotor.class, "lift_arm");

        telemetry.addData("Status: ", "Hardware Configured");
        telemetry.update();
        
        // Creating Tfod Instance
        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }
        
        // Activating ...
        if (tfod != null) {
            tfod.activate();
        }
         
        backleftDrive.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        int SkystonePosition1 = 0;
        while (opModeIsActive()) {
          // Telling that Program s Running
          telemetry.addData("Program", "Running!");
          telemetry.update();
          if (tfod != null && SkystonePosition1 == 0) {
            boolean stone = false;
            boolean skystone = false;
            List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
            if (updatedRecognitions != null) { 
                for (Recognition recog: updatedRecognitions) {
                    if (recog.getLabel().equals("Skystone")) {
                        // ObjectAngle = recog.estimateAngleToObject(AngleUnit.DEGREES);
                        // telemetry.addData("Object Angle", ObjectAngle);
                        frontleftDrive.setPower(-.4);
                        frontrightDrive.setPower(.4);
                        backleftDrive.setPower(.4);
                        backrightDrive.setPower(-.4);
                        sleep(1250);
                        telemetry.addData("# Object Detected", updatedRecognitions.size());
                        telemetry.update();
                        telemetry.addData("Count", count);
                        telemetry.update();
                        frontleftDrive.setPower(0);
                        frontrightDrive.setPower(0);
                        backleftDrive.setPower(0);
                        backrightDrive.setPower(0);
                        sleep(500);
                        lift_arm.setPower(-.4);
                        frontleftDrive.setPower(0);
                        frontrightDrive.setPower(0);
                        backleftDrive.setPower(0);
                        backrightDrive.setPower(0);
                        sleep(500);
                        frontleftDrive.setPower(.3);
                        frontrightDrive.setPower(.3);
                        backleftDrive.setPower(.3);
                        backrightDrive.setPower(.3);
                        sleep(1650);
                        frontleftDrive.setPower(0);
                        frontrightDrive.setPower(0);
                        backleftDrive.setPower(0);
                        backrightDrive.setPower(0);
                        sleep(500);
                        lift_arm.setPower(.3);
                        frontleftDrive.setPower(0);
                        frontrightDrive.setPower(0);
                        backleftDrive.setPower(0);
                        backrightDrive.setPower(0);
                        sleep(2000);
                        grabber_vert.setPosition(1);
                        frontleftDrive.setPower(0);
                        frontrightDrive.setPower(0);
                        backleftDrive.setPower(0);
                        backrightDrive.setPower(0);
                        sleep(3000);
                        lift_arm.setPower(-.4);
                        frontleftDrive.setPower(0);
                        frontrightDrive.setPower(0);
                        backleftDrive.setPower(0);
                        backrightDrive.setPower(0);
                        sleep(500);
                        frontleftDrive.setPower(-.4);
                        frontrightDrive.setPower(-.4);
                        backleftDrive.setPower(-.4);
                        backrightDrive.setPower(-.4);
                        sleep(100);
                        frontleftDrive.setPower(-.4);
                        frontrightDrive.setPower(.4);
                        backleftDrive.setPower(-.4);
                        backrightDrive.setPower(.4);
                        sleep(1150);
                        lift_arm.setPower(.001);
                        while (assess < count + 23000) {
                            frontleftDrive.setPower(.3);
                            frontrightDrive.setPower(.3);
                            backleftDrive.setPower(.3);
                            backrightDrive.setPower(.3);
                            assess += 1;
                        }
                        lift_arm.setPower(-.4);
                        frontleftDrive.setPower(.3);
                        frontrightDrive.setPower(.3);
                        backleftDrive.setPower(.3);
                        backrightDrive.setPower(.3);
                        sleep(500);
                        lift_arm.setPower(.4);
                        grabber_vert.setPosition(0);
                        frontleftDrive.setPower(0);
                        frontrightDrive.setPower(0);
                        backleftDrive.setPower(0);
                        backrightDrive.setPower(0);
                        sleep(500);
                        lift_arm.setPower(-.4);
                        frontleftDrive.setPower(-.4);
                        frontrightDrive.setPower(-.4);
                        backleftDrive.setPower(-.4);
                        backrightDrive.setPower(-.4);
                        sleep(300);
                        frontleftDrive.setPower(-.4);
                        frontrightDrive.setPower(.4);
                        backleftDrive.setPower(-.4);
                        backrightDrive.setPower(.4);
                        sleep(2200);
                        lift_arm.setPower(.4);
                        frontleftDrive.setPower(.3);
                        frontrightDrive.setPower(.3);
                        backleftDrive.setPower(.3);
                        backrightDrive.setPower(.3);
                        sleep(1000);
                        frontleftDrive.setPower(0);
                        frontrightDrive.setPower(0);
                        backleftDrive.setPower(0);
                        backrightDrive.setPower(0);
                        sleep(10000);
                    }
                }
            }  
          }
          // Strafing Continuosly
          if (SkystonePosition1 == 0) {
              frontleftDrive.setPower(.4);
              frontrightDrive.setPower(-.4);
              backleftDrive.setPower(-.4);
              backrightDrive.setPower(.4);
              count += 1;
          } 
          
          
          }
        
    }
    // Initializing Vuforia
    private void initVuforia() {

        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = "AZAarN7/////AAABmbwaPFXcCUKSuQXshhARVD0edTn5yksB2f5i9qUU/5VB4UkFTmki8BWBIyVGemPQFrTp5KfsGLrHy1FTZePcR9qfC3PD0IyiGJGy1Vbxp1dA4PUCvinmAPUEPZLopfxRYzyFc7uIhljkjcdiOLLzqreumEb2c4/7s1n4AgkxAxs8H6k/Mg+FCNOWqbSekb7msXG8IjgcqGrH7J16MYjvNZw8KHMShM2QDNyzfyyKVrSA4Hw1Ys6zc9yGuuC/go5IOWhFdqvwLMfEA331wfcLCPxXAXSTeOpfN+Jy7vRk8DMeoq5aooF5k3U5xXjyTxwJdzttGnmfNifw7kI8/GWvZS9U8FGjoki2QruawoJDJ3CZ";
        parameters.cameraName = hardwareMap.get(WebcamName.class, "head_webcam");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
    }

    // Loading Models ....
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
            "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
       tfodParameters.minimumConfidence = 0.6;
       tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
       tfod.loadModelFromAsset(TFOD_MODEL_ASSET,  LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }
}
