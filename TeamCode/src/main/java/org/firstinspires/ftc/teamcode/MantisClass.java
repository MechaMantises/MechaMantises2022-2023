package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

public class MantisClass {
    LinearOpMode op;
    DcMotor slides;
    Servo claw;
    SampleMecanumDrive drive;

    public MantisClass(LinearOpMode opMode){
        op = opMode;
        drive = new SampleMecanumDrive(op.hardwareMap);
        slides = op.hardwareMap.dcMotor.get("slide");
        claw = op.hardwareMap.servo.get("claw");
        claw.setPosition(0.3);
        slides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);



    }
    public void AutoBlueLeft(String pos){
        drive.setPoseEstimate(new Pose2d(-30,70.5-9, Math.toRadians(270)));
        TrajectorySequence traj  = drive.trajectorySequenceBuilder(new Pose2d(-30,70.5-9,Math.toRadians(270)))
                .lineTo(new Vector2d(-30, 70.5-10))
                .strafeTo(new Vector2d(-12, 70.5-10))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(2100-150);

                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .lineTo(new Vector2d(-12, 35))
                .turn(Math.toRadians(-45))
                .lineTo(new Vector2d(-16+1, 31.3+1))
                .build();
        TrajectorySequence traj2 = drive.trajectorySequenceBuilder(new Pose2d(-16.2,31.5,Math.toRadians(225)))
                .lineTo(new Vector2d(-12, 35))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(425);
                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .turn(Math.toRadians(45))
                .lineTo(new Vector2d(-12, 12))
                .turn(Math.toRadians(-90))
                .lineTo(new Vector2d(-56.5, 13))
                .build();

        TrajectorySequence traj4 = drive.trajectorySequenceBuilder(new Pose2d(-56.7,13, Math.toRadians(180)))
                .lineTo(new Vector2d(-21, 12))
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
        TrajectorySequence traj5 = drive.trajectorySequenceBuilder(new Pose2d(-21, 12, Math.toRadians(90)))
                //.back(2)
                .turn(Math.toRadians(90))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(350);

                    slides.setPower(0.6);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                //  .strafeTo(new Vector2d(-19.8,13.5))
                .lineTo(new Vector2d(-56.7, 13))

                .build();
        TrajectorySequence traj6 = drive.trajectorySequenceBuilder(new Pose2d(-56.35,13, Math.toRadians(90)))
                        .back(2)
                                .strafeRight(10)
                                        .build();
        TrajectorySequence traj7 = drive.trajectorySequenceBuilder(new Pose2d  (-56.35,13, Math.toRadians(90)))
                        .back(2)
                                .strafeLeft(10)
                                        .build();

        TrajectorySequence traj8 = drive.trajectorySequenceBuilder(new Pose2d  (-56.35,13, Math.toRadians(90)))
                .back(2)
                .strafeLeft(20)
                .build();




        slides.setTargetPosition(500);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive.followTrajectorySequence(traj);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(500);
        drive.setPoseEstimate(new Pose2d(-16.2,31.5,Math.toRadians(225)));
        drive.followTrajectorySequence(traj2);
        op.sleep(500);
        claw.setPosition(0.3);
        op.sleep(500);
        slides.setTargetPosition(900);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()<900){

        }
        drive.setPoseEstimate(new Pose2d(-56.7,13, Math.toRadians(180)));
        drive.followTrajectorySequence(traj4);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(1000);
        drive.setPoseEstimate(new Pose2d(-21, 13, Math.toRadians(90)));
        drive.followTrajectorySequence(traj5);
        op.sleep(500);
        claw.setPosition(0.3);
        op.sleep(500);
        slides.setTargetPosition(825);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()<825){

        }
        drive.setPoseEstimate(new Pose2d(-56.7,13, Math.toRadians(180)));
        drive.followTrajectorySequence(traj4);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(500);
        slides.setTargetPosition(0);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (pos == "left"){
            drive.setPoseEstimate(new Pose2d(-56.35,13, Math.toRadians(90)));
            drive.followTrajectorySequence(traj6);


        }
        else if (pos == "middle"){
            drive.setPoseEstimate(new Pose2d(-56.35,13, Math.toRadians(90)));

            drive.followTrajectorySequence(traj7);

        }
        else if(pos == "right"){
            drive.setPoseEstimate(new Pose2d(-56.35,13, Math.toRadians(90)));
            drive.followTrajectorySequence(traj8);


        }
        while (slides.getCurrentPosition()>0){

        }


    }
    public void AutoBlueRight(String pos){
        drive.setPoseEstimate(new Pose2d(30,70.5-9, Math.toRadians(270)));
        TrajectorySequence traj  = drive.trajectorySequenceBuilder(new Pose2d(30,70.5-9,Math.toRadians(270)))
                .lineTo(new Vector2d(30, 70.5-10))
                .strafeTo(new Vector2d(12, 70.5-10))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(2100-150);

                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .lineTo(new Vector2d(12, 31))
                .turn(Math.toRadians(45))
                .lineTo(new Vector2d(12+1, 31-1))
                .build();
        TrajectorySequence traj2 = drive.trajectorySequenceBuilder(new Pose2d(16.2,31.5,Math.toRadians(315)))
                .lineTo(new Vector2d(12, 35))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(425);
                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .turn(Math.toRadians(-45))
                .lineTo(new Vector2d(12, 13.5))
                .turn(Math.toRadians(90)) //0
                .lineTo(new Vector2d(58, 13))
                .build();

        TrajectorySequence traj4 = drive.trajectorySequenceBuilder(new Pose2d(58,13.5, Math.toRadians(0)))
                .lineTo(new Vector2d(26, 13.5))
                .addDisplacementMarker( ()-> {
                            slides.setTargetPosition(2100 - 150);

                            slides.setPower(0.5);
                            slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        }
                )
                .turn(Math.toRadians(90))
//                .lineTo(new Vector2d(-23.8, 19.4))
//                .lineTo(new Vector2d(-23.8, 11.6))
//                .turn(Math.toRadians(90))
//                .lineTo(new Vector2d(-61.4, 11.6))
//                .lineTo(new Vector2d(-23.8, 11.6))
//                .turn(Math.toRadians(-90))
//                .lineTo(new Vector2d(-23.8, 19.4))
                .build();
        TrajectorySequence traj5 = drive.trajectorySequenceBuilder(new Pose2d(26, 13.5, Math.toRadians(90)))
                .turn(Math.toRadians(-90))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(350);

                    slides.setPower(0.6);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                //  .strafeTo(new Vector2d(-19.8,13.5))
                .lineTo(new Vector2d(58.5, 13.5))

                .build();
        TrajectorySequence traj6 = drive.trajectorySequenceBuilder(new Pose2d(56.35,13.5, Math.toRadians(90)))
                .back(2)
                .strafeLeft(11)
                .build();
        TrajectorySequence traj7 = drive.trajectorySequenceBuilder(new Pose2d  (56.35,13.5, Math.toRadians(90)))
                .back(2)
                .strafeRight(10)
                .build();

        TrajectorySequence traj8 = drive.trajectorySequenceBuilder(new Pose2d  (56.35,13.5, Math.toRadians(90)))
                .back(2)
                .strafeRight(35)
                .build();




        slides.setTargetPosition(500);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive.followTrajectorySequence(traj);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(500);
        drive.setPoseEstimate(new Pose2d(16.2,31.5,Math.toRadians(315)));
        drive.followTrajectorySequence(traj2);
        op.sleep(500);
        claw.setPosition(0.3);
        op.sleep(500);
        slides.setTargetPosition(900);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()<900){

        }
        drive.setPoseEstimate(new Pose2d(58,13.5, Math.toRadians(0)));
        drive.followTrajectorySequence(traj4);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(1000);
        drive.setPoseEstimate(new Pose2d(26, 13.5, Math.toRadians(90)));
        drive.followTrajectorySequence(traj5);
        op.sleep(500);
        claw.setPosition(0.3);
        op.sleep(500);
        slides.setTargetPosition(825);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()<825){

        }
        drive.setPoseEstimate(new Pose2d(58,13.5, Math.toRadians(0)));
        drive.followTrajectorySequence(traj4);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(500);
        slides.setTargetPosition(0);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (pos == "left"){
            drive.setPoseEstimate(new Pose2d(56.35,13.5, Math.toRadians(90)));
            drive.followTrajectorySequence(traj8);


        }
        else if (pos == "middle"){
            drive.setPoseEstimate(new Pose2d(56.35,13.5, Math.toRadians(90)));
            drive.followTrajectorySequence(traj7);

        }
        else if(pos == "right"){
            drive.setPoseEstimate(new Pose2d(56.35,13.5, Math.toRadians(90)));
            drive.followTrajectorySequence(traj6);


        }
        while (slides.getCurrentPosition()>0){

        }

    }
}
