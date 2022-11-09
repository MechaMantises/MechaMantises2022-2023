package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
public class thingy2 extends LinearOpMode {
    DcMotor slides;
    Servo claw;

    @Override
    public void runOpMode() throws InterruptedException {
        slides = hardwareMap.dcMotor.get("slide");
        claw = hardwareMap.servo.get("claw");
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(new Pose2d(-35,70.5-9, Math.toRadians(270)));
        claw.setPosition(0.3);
        slides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        waitForStart();

        TrajectorySequence traj  = drive.trajectorySequenceBuilder(new Pose2d(-35,70.5-9,Math.toRadians(270)))
                .lineTo(new Vector2d(-35, 70.5-10))
                .strafeTo(new Vector2d(-13, 70.5-10))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(2100-150);

                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .lineTo(new Vector2d(-13, 35))
                .turn(Math.toRadians(-45))
                .lineTo(new Vector2d(-16.2, 31.5))
                .build();
        TrajectorySequence traj2 = drive.trajectorySequenceBuilder(new Pose2d(-16.2,31.5,Math.toRadians(225)))
                .lineTo(new Vector2d(-13, 35))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(425);
                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .turn(Math.toRadians(45))
                .lineTo(new Vector2d(-13, 13.5))
                .turn(Math.toRadians(-90))
                .lineTo(new Vector2d(-56.5, 13.5))
                .build();

TrajectorySequence traj4 = drive.trajectorySequenceBuilder(new Pose2d(-56.5,13.5, Math.toRadians(180)))
                .lineTo(new Vector2d(-21, 11.6))
        .addDisplacementMarker( ()-> {
            slides.setTargetPosition(2100 - 150);

            slides.setPower(0.5);
            slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    )
                .turn(Math.toRadians(-90))
//                .lineTo(new Vector2d(-23.8, 19.4))
//                .lineTo(new Vector2d(-23.8, 11.6))
//                .turn(Math.toRadians(90))
//                .lineTo(new Vector2d(-61.4, 11.6))
//                .lineTo(new Vector2d(-23.8, 11.6))
//                .turn(Math.toRadians(-90))
//                .lineTo(new Vector2d(-23.8, 19.4))
                .build();
TrajectorySequence traj5 = drive.trajectorySequenceBuilder(new Pose2d(-19.8, 11.6, Math.toRadians(90)))
        .turn(Math.toRadians(90))
        .addDisplacementMarker(()->{
            slides.setTargetPosition(350);

            slides.setPower(0.5);
            slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        })
      //  .strafeTo(new Vector2d(-19.8,13.5))
        .lineTo(new Vector2d(-55, 11.5))

                .build();





        slides.setTargetPosition(500);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive.followTrajectorySequence(traj);
        sleep(500);
        claw.setPosition(0.6);
        sleep(500);
        drive.setPoseEstimate(new Pose2d(-16.2,31.5,Math.toRadians(225)));
        drive.followTrajectorySequence(traj2);
        sleep(500);
        claw.setPosition(0.3);
        sleep(500);
        slides.setTargetPosition(900);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()<900){

        }
        drive.setPoseEstimate(new Pose2d(-56.5,13.5, Math.toRadians(180)));
        drive.followTrajectorySequence(traj4);
        sleep(500);
        claw.setPosition(0.6);
        sleep(1000);
        drive.setPoseEstimate(new Pose2d(-19.8, 11.6, Math.toRadians(90)));
        drive.followTrajectorySequence(traj5);
        sleep(500);
        claw.setPosition(0.3);
        sleep(500);
        slides.setTargetPosition(825);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()<825){

        }
        drive.setPoseEstimate(new Pose2d(-56.5,13.5, Math.toRadians(180)));
        drive.followTrajectorySequence(traj4);
        sleep(500);
        claw.setPosition(0.6);
        sleep(500);
        slides.setTargetPosition(0);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()>0){

        }
stop();


























    }
}

