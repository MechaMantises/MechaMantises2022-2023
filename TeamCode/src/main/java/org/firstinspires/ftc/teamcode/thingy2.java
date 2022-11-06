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

        waitForStart();

        if (isStopRequested()) return;

        Trajectory traj = drive.trajectoryBuilder(
        new Pose2d(-35,70.5-9, Math.toRadians(270)))
                                .lineTo(new Vector2d(-35, 70.5-10))
                .strafeTo(new Vector2d(-13, 70.5-10))
                .lineTo(new Vector2d(-13, 48))
                .splineTo(new Vector2d(-13,34), Math.toRadians(270-45))
                        .build();



        drive.followTrajectory(traj);


    }
}

