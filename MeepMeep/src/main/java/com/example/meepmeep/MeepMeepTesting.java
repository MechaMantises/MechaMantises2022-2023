package com.example.meepmeep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(52.48, 52.48, Math.toRadians(281.5), Math.toRadians(222.7), 13.56)
                .followTrajectorySequence(drive ->


                       drive.trajectorySequenceBuilder(new Pose2d(30,70.5-9,Math.toRadians(270)))
                        .lineTo(new Vector2d(30, 70.5-10))
                        .lineToConstantHeading(new Vector2d(12, 70.5-10))
                               .setTangent(Math.toRadians(270))
                               .splineTo(new Vector2d(16, 33),Math.toRadians(315) )



                .build()

                );



        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}



















