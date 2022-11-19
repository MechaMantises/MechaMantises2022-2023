package org.firstinspires.ftc.teamcode.auton;

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
        claw.setPosition(0.25);
        slides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);



    }
    public void AutoPark1and1(String pos){
        drive.setPoseEstimate(new Pose2d(-30,70.5-9, Math.toRadians(270)));
        TrajectorySequence traj  = drive.trajectorySequenceBuilder(new Pose2d(-30,70.5-9,Math.toRadians(270)))
                .lineTo(new Vector2d(-30, 60.5))
                .lineToConstantHeading(new Vector2d(-14, 60.5))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(2100-150);

                    slides.setPower(0.7);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .setTangent(Math.toRadians(270))
                .splineTo(new Vector2d(-16.25, 31.5),Math.toRadians(225) )
                .build();
        TrajectorySequence traj2 = drive.trajectorySequenceBuilder(traj.end())
                .lineTo(new Vector2d(-10.45, 37.3))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(400);
                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .turn(Math.toRadians(45))
                .lineTo(new Vector2d(-12.45, 10.7))
                .turn(Math.toRadians(-90)) //0
                .lineTo(new Vector2d(-56, 10.7))


                .build();
        TrajectorySequence traj3 = drive.trajectorySequenceBuilder(traj2.end())
                .addDisplacementMarker( ()-> {
                            slides.setTargetPosition(2100 - 150);

                            slides.setPower(0.8);
                            slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        }
                )
                .lineTo(new Vector2d(-40, 10.7))
                .turn(Math.toRadians(-90))
                .lineToConstantHeading(new Vector2d(-20, 10.7))

                .lineTo(new Vector2d(-20, 14))
                .build();
        TrajectorySequence traj4 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(-20,10.7))
                .addDisplacementMarker(()-> {
                    slides.setTargetPosition(300);

                    slides.setPower(0.6);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .turn(Math.toRadians(90))
                .lineTo(new Vector2d(-56, 10.7))

                .build();
        TrajectorySequence traj5 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(-55,10.7))
                .build();
        TrajectorySequence traj9 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(-20,10))
                .build();



        TrajectorySequence traj6 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(-20, 10.7))
                .strafeRight(11)
                .build();
        TrajectorySequence traj7 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(-20, 10.7))
                .strafeLeft(10)
                .build();

        TrajectorySequence traj8 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(-20, 10.7))
                .strafeLeft(35)
                .build();




        slides.setTargetPosition(500);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive.followTrajectorySequence(traj);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(500);
        drive.setPoseEstimate(traj.end());
        drive.followTrajectorySequence(traj2);
        op.sleep(500);
        claw.setPosition(0.3);
        op.sleep(500);
        drive.setPoseEstimate(traj2.end());
        drive.followTrajectorySequence(traj5);
        slides.setTargetPosition(900);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()<900){

        }
        drive.setPoseEstimate(traj5.end());
        drive.followTrajectorySequence(traj3);
        op.sleep(500);
        claw.setPosition(0.6);
        // sleep(10000);
        op.sleep(500);
        drive.setPoseEstimate(traj3.end());
        drive.followTrajectorySequence(traj9);
         slides.setTargetPosition(0);
        slides.setPower(0.8);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (pos == "left"){
            drive.setPoseEstimate(traj3.end());
            drive.followTrajectorySequence(traj6);


        }
        else if (pos == "middle"){
            drive.setPoseEstimate(traj3.end());
            drive.followTrajectorySequence(traj7);

        }
        else if(pos == "right"){
            drive.setPoseEstimate(traj3.end());
            drive.followTrajectorySequence(traj8);


        }
        while (slides.getCurrentPosition()>0){

        }

    }
    public void AutoPark2(String pos){
        drive.setPoseEstimate(new Pose2d(30,70.5-9, Math.toRadians(270)));
        TrajectorySequence traj  = drive.trajectorySequenceBuilder(new Pose2d(30,70.5-9,Math.toRadians(270)))
                .lineTo(new Vector2d(30, 60.5))
                .lineToConstantHeading(new Vector2d(14, 60.5))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(2100-150);

                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .setTangent(Math.toRadians(270))
                .splineTo(new Vector2d(13.45, 28.3),Math.toRadians(315) )
                .build();
        TrajectorySequence traj2 = drive.trajectorySequenceBuilder(traj.end())
                .lineTo(new Vector2d(10.5, 31.8))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(0);
                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .turn(Math.toRadians(-45))
                .lineTo(new Vector2d(10.5, 10.6))


                .build();



        TrajectorySequence traj6 = drive.trajectorySequenceBuilder(traj2.end())
                //.lineTo(new Vector2d(22, 10))
                .strafeLeft(24)
                .build();

        TrajectorySequence traj8 = drive.trajectorySequenceBuilder(traj2.end())
                //.lineTo(new Vector2d(22, 10))
                .strafeLeft(48)
                .build();





        slides.setTargetPosition(500);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive.followTrajectorySequence(traj);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(500);
        drive.setPoseEstimate(traj.end());
        drive.followTrajectorySequence(traj2);

        if (pos == "left"){
            drive.setPoseEstimate(traj2.end());
            drive.followTrajectorySequence(traj8);


        }
        else if (pos == "middle"){
            drive.setPoseEstimate(traj2.end());
            drive.followTrajectorySequence(traj6);

        }
        else if(pos == "right"){




        }
        while (slides.getCurrentPosition()>0){

        }
    }
    public void AutoPark(String pos){
        drive.setPoseEstimate(new Pose2d(-30,70.5-9, Math.toRadians(270)));
        TrajectorySequence traj  = drive.trajectorySequenceBuilder(new Pose2d(-30,70.5-9,Math.toRadians(270)))
                .lineTo(new Vector2d(-30, 60.5))
                .lineToConstantHeading(new Vector2d(-14, 60.5))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(2100-150);

                    slides.setPower(0.7);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .setTangent(Math.toRadians(270))
                .splineTo(new Vector2d(-16.25, 31.5),Math.toRadians(225) )
                .build();
        TrajectorySequence traj2 = drive.trajectorySequenceBuilder(traj.end())
                .lineTo(new Vector2d(-10.45, 37.3))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(0);
                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .turn(Math.toRadians(45))
                .lineTo(new Vector2d(-12.45, 10.7))

                 //0


                .build();


        TrajectorySequence traj6 = drive.trajectorySequenceBuilder(traj2.end())

                .strafeRight(48)
                .build();
        TrajectorySequence traj7 = drive.trajectorySequenceBuilder(traj2.end())
               // .lineTo(new Vector2d(-20, 10.7))
                .strafeRight(24)
                .build();






        slides.setTargetPosition(500);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive.followTrajectorySequence(traj);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(500);
        drive.setPoseEstimate(traj.end());
        drive.followTrajectorySequence(traj2);

        if (pos == "left"){


        }
        else if (pos == "middle"){
            drive.setPoseEstimate(traj2.end());
            drive.followTrajectorySequence(traj7);

        }
        else if(pos == "right"){
            drive.setPoseEstimate(traj2.end());
            drive.followTrajectorySequence(traj6);


        }
        while (slides.getCurrentPosition()>0){

        }

    }
    public void AutoBlueLeft(String pos){
        drive.setPoseEstimate(new Pose2d(-30,70.5-9, Math.toRadians(270)));
        TrajectorySequence traj  = drive.trajectorySequenceBuilder(new Pose2d(-30,70.5-9,Math.toRadians(270)))
                .lineTo(new Vector2d(-30, 60.5))
                .lineToConstantHeading(new Vector2d(-14, 60.5))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(2100-150);

                       slides.setPower(0.7);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .setTangent(Math.toRadians(270))
                .splineTo(new Vector2d(-16.25, 31.5),Math.toRadians(225) )
                .build();
        TrajectorySequence traj2 = drive.trajectorySequenceBuilder(traj.end())
                .lineTo(new Vector2d(-10.45, 37.3))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(400);
                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .turn(Math.toRadians(45))
                .lineTo(new Vector2d(-12.45, 10.7))
                .turn(Math.toRadians(-90)) //0
                .lineTo(new Vector2d(-56, 10.7))


                .build();
        TrajectorySequence traj3 = drive.trajectorySequenceBuilder(traj2.end())
                .addDisplacementMarker( ()-> {
                            slides.setTargetPosition(2100 - 150);

                            slides.setPower(0.8);
                            slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        }
                )
                .lineTo(new Vector2d(-40, 10.7))
                .turn(Math.toRadians(-90))
                .lineToConstantHeading(new Vector2d(-20, 10.7))

                .lineTo(new Vector2d(-20, 15))
                .build();
        TrajectorySequence traj4 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(-20,10.7))
                .addDisplacementMarker(()-> {
                    slides.setTargetPosition(300);

                    slides.setPower(0.6);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .turn(Math.toRadians(90))
                .lineTo(new Vector2d(-56, 10.7))

                .build();



        TrajectorySequence traj6 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(-20, 10.7))
                .strafeRight(11)
                .build();
        TrajectorySequence traj7 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(-20, 10.7))
                .strafeLeft(10)
                .build();

        TrajectorySequence traj8 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(-20, 10.7))
                .strafeLeft(35)
                .build();




        slides.setTargetPosition(500);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive.followTrajectorySequence(traj);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(500);
        drive.setPoseEstimate(traj.end());
        drive.followTrajectorySequence(traj2);
        op.sleep(500);
        claw.setPosition(0.3);
        op.sleep(500);
        slides.setTargetPosition(900);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()<900){

        }
        drive.setPoseEstimate(traj2.end());
        drive.followTrajectorySequence(traj3);
        op.sleep(500);
        claw.setPosition(0.6);
        // sleep(10000);
        drive.setPoseEstimate(traj3.end());
        drive.followTrajectorySequence(traj4);
        op.sleep(500);
        claw.setPosition(0.3);
        op.sleep(500);
        slides.setTargetPosition(900);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()<900){

        }
        drive.setPoseEstimate(traj4.end());
        drive.followTrajectorySequence(traj3);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(500);
        slides.setTargetPosition(0);
        slides.setPower(0.8);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (pos == "left"){
            drive.setPoseEstimate(traj3.end());
            drive.followTrajectorySequence(traj6);


        }
        else if (pos == "middle"){
            drive.setPoseEstimate(traj3.end());
            drive.followTrajectorySequence(traj7);

        }
        else if(pos == "right"){
            drive.setPoseEstimate(traj3.end());
            drive.followTrajectorySequence(traj8);


        }
        while (slides.getCurrentPosition()>0){

        }


    }
    public void AutoBlueRight(String pos){
        drive.setPoseEstimate(new Pose2d(30,70.5-9, Math.toRadians(270)));
        TrajectorySequence traj  = drive.trajectorySequenceBuilder(new Pose2d(30,70.5-9,Math.toRadians(270)))
                .lineTo(new Vector2d(30, 60.5))
                .lineToConstantHeading(new Vector2d(14, 60.5))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(2100-150);

                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .setTangent(Math.toRadians(270))
                .splineTo(new Vector2d(13.45, 28.3),Math.toRadians(315) )
                .build();
        TrajectorySequence traj2 = drive.trajectorySequenceBuilder(traj.end())
                .lineTo(new Vector2d(10.5, 31.8))
                .addDisplacementMarker(()->{
                    slides.setTargetPosition(400);
                    slides.setPower(0.5);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .turn(Math.toRadians(-45))
                .lineTo(new Vector2d(10.5, 10.6))
                .turn(Math.toRadians(90)) //0
                .lineTo(new Vector2d(55, 10.6))


                .build();
        TrajectorySequence traj3 = drive.trajectorySequenceBuilder(traj2.end())
                .addDisplacementMarker( ()-> {
                            slides.setTargetPosition(2100 - 150);

                            slides.setPower(0.8);
                            slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        }
                )
                .lineTo(new Vector2d(40, 10.6))
                .turn(Math.toRadians(90))
                .lineToConstantHeading(new Vector2d(22, 10))

                .lineTo(new Vector2d(22, 15))
                .build();
        TrajectorySequence traj4 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(22,10))
                .addDisplacementMarker(()-> {
                    slides.setTargetPosition(300);

                    slides.setPower(0.6);
                    slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                })
                .turn(Math.toRadians(-90))
                .lineTo(new Vector2d(55, 10.6))

                .build();



        TrajectorySequence traj6 = drive.trajectorySequenceBuilder(traj3.end())
                //.lineTo(new Vector2d(22, 10))
                .strafeLeft(11)
                .build();
        TrajectorySequence traj7 = drive.trajectorySequenceBuilder(traj3.end())
              //  .lineTo(new Vector2d(22, 10))
                .strafeRight(10)
                .build();

        TrajectorySequence traj8 = drive.trajectorySequenceBuilder(traj3.end())
                //.lineTo(new Vector2d(22, 10))
                .strafeRight(35)
                .build();
        TrajectorySequence traj5 = drive.trajectorySequenceBuilder(traj3.end())
                .lineTo(new Vector2d(22, 10))
                        .build();




        slides.setTargetPosition(500);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive.followTrajectorySequence(traj);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(500);
        drive.setPoseEstimate(traj.end());
        drive.followTrajectorySequence(traj2);
        op.sleep(500);
        claw.setPosition(0.3);
        op.sleep(500);
        slides.setTargetPosition(900);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()<900){

        }
        drive.setPoseEstimate(traj2.end());
        drive.followTrajectorySequence(traj3);
        op.sleep(500);
        claw.setPosition(0.6);
        // sleep(10000);
        drive.setPoseEstimate(traj3.end());
        drive.followTrajectorySequence(traj4);
        op.sleep(500);
        claw.setPosition(0.3);
        op.sleep(500);
        slides.setTargetPosition(900);
        slides.setPower(0.5);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (slides.getCurrentPosition()<900){

        }
        drive.setPoseEstimate(traj4.end());
        drive.followTrajectorySequence(traj3);
        op.sleep(500);
        claw.setPosition(0.6);
        op.sleep(500);
        drive.setPoseEstimate(traj3.end());
        drive.followTrajectorySequence(traj5);
        slides.setTargetPosition(0);
        slides.setPower(0.8);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (pos == "left"){
            drive.setPoseEstimate(traj3.end());
            drive.followTrajectorySequence(traj8);


        }
        else if (pos == "middle"){
            drive.setPoseEstimate(traj3.end());
            drive.followTrajectorySequence(traj7);

        }
        else if(pos == "right"){
            drive.setPoseEstimate(traj3.end());
            drive.followTrajectorySequence(traj6);


        }
        while (slides.getCurrentPosition()>0){

        }
    }
}
