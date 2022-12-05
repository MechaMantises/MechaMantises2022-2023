package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name = "fdjaoifjaoifjaof")
public class runningtest extends OpMode {
    DcMotor rightFront;
    DcMotor leftFront;
    DcMotor slides;
    public static int currentpos;
    @Override
    public void init() {
        slides = hardwareMap.dcMotor.get("slides");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftFront = hardwareMap.dcMotor.get("leftFront");

        slides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }
    @Override
    public void loop() {
        currentpos = slides.getCurrentPosition();
        telemetry.addData("encoderpos", currentpos);
        if(gamepad1.y) {
            slides.setTargetPosition(2000);
            slides.setPower(0.5);
            slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }else if(gamepad1.a) {
            slides.setTargetPosition(0);
            slides.setPower(0.5);
            slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
telemetry.update();
        rightFront.setPower(gamepad1.right_stick_x);
        leftFront.setPower(gamepad2.right_stick_x);


    }
}
