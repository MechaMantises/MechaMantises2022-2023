package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
public class thingy2 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(new Pose2d(-35,70.5-9, Math.toRadians(270)));


        waitForStart();

        if (isStopRequested()) return;

drive.followTrajectorySequence(drive.trajectorySequenceBuilder(new Pose2d(-35,70.5-9, Math.toRadians(270)))



        .lineTo(new Vector2d(-35, 70.5-10))
        .strafeTo(new Vector2d(-13, 70.5-10))
        .lineTo(new Vector2d(-13, 34))
        .turn(Math.toRadians(-45))
        .lineTo(new Vector2d(-21.9, 26.9))
        .lineTo(new Vector2d(-13, 34))
        .turn(Math.toRadians(45))
        .lineTo(new Vector2d(-13, 11.5))
        .turn(Math.toRadians(-90))
        .lineTo(new Vector2d(-61.4, 11.6))
        .lineTo(new Vector2d(-23.8, 11.6))
        .turn(Math.toRadians(-90))
        .lineTo(new Vector2d(-23.8, 19.4))
        .lineTo(new Vector2d(-23.8, 11.6))
        .turn(Math.toRadians(90))
        .lineTo(new Vector2d(-61.4, 11.6))
        .lineTo(new Vector2d(-23.8, 11.6))
        .turn(Math.toRadians(-90))
        .lineTo(new Vector2d(-23.8, 19.4))
        .build());










    }
}

