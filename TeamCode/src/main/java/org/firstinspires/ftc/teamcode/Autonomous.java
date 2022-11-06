package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Autnomous")

public class Autonomous extends LinearOpMode {
    LinearOpMode op;
    DcMotor fl_wheel;
    DcMotor bl_wheel;
    DcMotor fr_wheel;
    DcMotor br_wheel;
    DcMotor slide;
    Servo claw;

    public void runOpMode(){


        fl_wheel = hardwareMap.dcMotor.get("leftFront");
        bl_wheel = hardwareMap.dcMotor.get("leftRear");
        fr_wheel = hardwareMap.dcMotor.get("rightFront");
        br_wheel = hardwareMap.dcMotor.get("rightRear");
        slide = hardwareMap.dcMotor.get("slide");
        claw = hardwareMap.servo.get("claw");
        fl_wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        bl_wheel.setDirection(DcMotorSimple.Direction.REVERSE);
waitForStart();
start();
      //4 inches of the
        claw.setPosition(0.3);
        sleep(1000);
slide.setTargetPosition(500);

        slide.setPower(0.3);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        move(30, 1, 0.5);
        turn(11,2);
        slide.setTargetPosition(2100-200);
        slide.setPower(0.3);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slide.isBusy()){

        }
        move(5,1,0.5);
        claw.setPosition(1);
        sleep(2000);
        move(5,4,0.5);
        turn(11,1);
        slide.setTargetPosition(0);

        slide.setPower(0.3);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(slide.isBusy()){

        }

        stop();

        //slide lift
        //drop



    }
    public void turn(int degrees, int direction) {
        int fl_wheel_tick = fl_wheel.getCurrentPosition();
        int bl_wheel_tick = bl_wheel.getCurrentPosition();
        int fr_wheel_tick = fr_wheel.getCurrentPosition();
        int br_wheel_tick = br_wheel.getCurrentPosition();
        switch (direction) {
            case 1:
                fl_wheel.setTargetPosition(fl_wheel_tick + (degrees * -41));
                fr_wheel.setTargetPosition(fr_wheel_tick + (degrees * 41));
                br_wheel.setTargetPosition(br_wheel_tick + (degrees * 41));
                bl_wheel.setTargetPosition(bl_wheel_tick + (degrees * -41));
                break;
            case 2:
                fl_wheel.setTargetPosition(fl_wheel_tick + degrees * 41);
                fr_wheel.setTargetPosition(fr_wheel_tick + degrees * -41);
                br_wheel.setTargetPosition(br_wheel_tick + degrees * -41);
                bl_wheel.setTargetPosition(bl_wheel_tick + degrees * 41);
                break;

        }
        fl_wheel.setPower(1);
        fr_wheel.setPower(1);
        br_wheel.setPower(1);
        bl_wheel.setPower(1);

        fl_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fr_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (bl_wheel.isBusy() || fr_wheel.isBusy() || fl_wheel.isBusy() || br_wheel.isBusy()) {

        }
    }

    public void move(int inches, int direction, double power) {
        int fl_wheel_tick = fl_wheel.getCurrentPosition();
        int bl_wheel_tick = bl_wheel.getCurrentPosition();
        int fr_wheel_tick = fr_wheel.getCurrentPosition();
        int br_wheel_tick = br_wheel.getCurrentPosition();
//        fl_wheel.setTargetPosition(inches * -41);
//        fr_wheel.setTargetPosition(inches * 41);
//        br_wheel.setTargetPosition(inches * -41);
//        bl_wheel.setTargetPosition(inches * 41);
        switch (direction) {
            case 1:
                fl_wheel.setTargetPosition(fl_wheel_tick+inches * 41);
                fr_wheel.setTargetPosition(fr_wheel_tick+inches * 41);
                br_wheel.setTargetPosition(br_wheel_tick+inches * 41);
                bl_wheel.setTargetPosition(bl_wheel_tick+inches * 41);
                break;
            case 2:
                fl_wheel.setTargetPosition(fl_wheel_tick+inches * 41);
                fr_wheel.setTargetPosition(fr_wheel_tick+inches * -41);
                br_wheel.setTargetPosition(br_wheel_tick+inches * 41);
                bl_wheel.setTargetPosition(bl_wheel_tick+inches * -41);
                break;
            case 3:
                fl_wheel.setTargetPosition(fl_wheel_tick+inches * -41);
                fr_wheel.setTargetPosition(fr_wheel_tick+inches * 41);
                br_wheel.setTargetPosition(br_wheel_tick+inches * -41);
                bl_wheel.setTargetPosition(bl_wheel_tick+inches * 41);
                break;
            case 4:
                fl_wheel.setTargetPosition(fl_wheel_tick+inches * -41);
                fr_wheel.setTargetPosition(fr_wheel_tick+inches * -41);
                br_wheel.setTargetPosition(br_wheel_tick+inches * -41);
                bl_wheel.setTargetPosition(bl_wheel_tick+inches * -41);
                break;


        }
        fl_wheel.setPower(power);
        fr_wheel.setPower(power);
        br_wheel.setPower(power);
        bl_wheel.setPower(power);



        fl_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fr_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //double runtime = op.getRuntime();

        while (bl_wheel.isBusy() || fr_wheel.isBusy() || fl_wheel.isBusy() || br_wheel.isBusy()) {
//            if(op.getRuntime()>runtime+maxtime){
//                break;
//            }
        }
//        fl_wheel.setPower(0);
//        fr_wheel.setPower(0);
//        br_wheel.setPower(0);
//        bl_wheel.setPower(0);


    }
}
