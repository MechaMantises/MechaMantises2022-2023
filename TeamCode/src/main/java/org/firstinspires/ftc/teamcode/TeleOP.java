package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "teleop")
public class TeleOP extends LinearOpMode {
    DcMotor leftFront;
    DcMotor leftRear;
    DcMotor rightFront;
    DcMotor rightRear;
    Servo claw;
    DcMotor slide;
    public void runOpMode(){
        leftFront = hardwareMap.dcMotor.get("leftFront");
        leftRear = hardwareMap.dcMotor.get("leftRear");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        rightRear = hardwareMap.dcMotor.get("rightRear");
        claw = hardwareMap.servo.get("claw");
        slide = hardwareMap.dcMotor.get("slide");



            leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
            leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
            claw.setPosition(0.3);
            slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            slide.setTargetPosition(500);
            slide.setPower(0.3);
            slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();
        while(opModeIsActive()) {
            telemetry.addData("endcoderpos ", slide.getCurrentPosition());
            telemetry.update();
            if(gamepad1.x){
                claw.setPosition(1);
            }
            if(gamepad1.b){
                claw.setPosition(0.3);
            }
            if(gamepad1.y){
                slide.setTargetPosition(2100-200);

                slide.setPower(0.3);
                slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            }
            if(gamepad1.a){
                slide.setTargetPosition(0);
                slide.setPower(0.3);

                slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if(gamepad1.dpad_right){
                slide.setTargetPosition(500);
                slide.setPower(0.3);
                slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }









            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx);
            double backLeftPower = (y - x + rx);
            double frontRightPower = (y - x - rx);
            double backRightPower = (y + x - rx);

            leftFront.setPower(frontLeftPower);
            leftRear.setPower(backLeftPower);
            rightFront.setPower(frontRightPower);
            rightRear.setPower(backRightPower);
        }


    }
}