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


                       drive.trajectorySequenceBuilder(new Pose2d(-35,70.5-9,Math.toRadians(270)))
                                .lineTo(new Vector2d(-35, 70.5-10))
                                .strafeTo(new Vector2d(-13, 70.5-10))

                                .lineTo(new Vector2d(-13, 35))
                                .turn(Math.toRadians(-45))
                                .lineTo(new Vector2d(-16.2, 31.5))


                .lineTo(new Vector2d(-13, 35))

                .turn(Math.toRadians(45))
                .lineTo(new Vector2d(-13, 13.5))
                .turn(Math.toRadians(-90))
                .lineTo(new Vector2d(-56.5, 13.5))



                .lineTo(new Vector2d(-21, 11.6))

                .turn(Math.toRadians(-90))
//

                .turn(Math.toRadians(90))
                               .lineTo(new Vector2d(-55, 11.5))

                .build()
                );



        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
