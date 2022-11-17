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
        drive.setPoseEstimate(new Pose2d(30,70.5-9, Math.toRadians(270)));
        claw.setPosition(0.3);
        slides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        waitForStart();

       TrajectorySequence traj  = drive.trajectorySequenceBuilder(new Pose2d(30,70.5-9,Math.toRadians(270)))
                       .lineTo(new Vector2d(30, 70.5-10))
                .lineToConstantHeading(new Vector2d(12, 70.5-10))
               .addDisplacementMarker(()->{
                   slides.setTargetPosition(2100-150);

                   slides.setPower(0.5);
                   slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               })
                .setTangent(Math.toRadians(270))
                .splineTo(new Vector2d(16, 33),Math.toRadians(315) )
                        .build();
        slides.setTargetPosition(500);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       drive.followTrajectorySequence(traj);
       sleep(500);
       claw.setPosition(0.6);
       sleep(500);


stop();


























    }
}

