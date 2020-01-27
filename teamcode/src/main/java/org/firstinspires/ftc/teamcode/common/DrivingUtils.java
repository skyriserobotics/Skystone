/*
package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.DcMotor;

public class DrivingUtils {

    private RobotConfig robotConfig = null;

    public DrivingUtils(RobotConfig robotConfig) {
        this.robotConfig = robotConfig;
    }




                                      double power; {
        DcMotor leftMotor = robotConfig.leftDrive;
        DcMotor rightMotor = robotConfig.rightDrive;

        /**
         * Based on our motor's specification
         * https://www.gobilda.com/5202-series-yellow-jacket-planetary-gear-motor-26-9-1-ratio-223-rpm-3-3-5v-encoder/
         * Encoder Countable Events Per Revolution (Output Shaft) = 753.2
         * Wheel diameter = 4 inches
         * Wheel perimeter (or distance in inches moved in one complete revolution) = 2 * PI * <wheel radius>
         * Encoder's positions (or countable events) per inch = 753.2/(2*3.14*2)
         *
         */
         /*
        final double encoderPositionsPerInch = 28/(2*3.14*2);

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        int encoderPositionsNeeded =
                (int)(encoderPositionsPerInch*inches);

        leftMotor.setTargetPosition(encoderPositionsNeeded);
        rightMotor.setTargetPosition(encoderPositionsNeeded);

        leftMotor.setPower(power);
        rightMotor.setPower(power);
        while (robotConfig.opMode.opModeIsActive() && leftMotor.isBusy()
                && rightMotor.isBusy()) {
            // Do nothing. We are waiting for the motors to report that they are done
        }
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    public void moveRobot(double power, long duration) {
        DcMotor leftMotor = robotConfig.leftDrive;
        DcMotor rightMotor = robotConfig.rightDrive;

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftMotor.setPower(power);
        rightMotor.setPower(power);

        robotConfig.opMode.sleep(duration);

        stopRobot();
    }

    public void stopRobot() {
        DcMotor leftMotor = robotConfig.leftDrive;
        DcMotor rightMotor = robotConfig.rightDrive;

        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
}
*/